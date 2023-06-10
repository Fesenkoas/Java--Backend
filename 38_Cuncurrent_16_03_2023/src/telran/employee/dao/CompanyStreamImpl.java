package telran.employee.dao;

import java.util.HashMap;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

public class CompanyStreamImpl implements Company {
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	Lock rLock= rwLock.readLock();
	Lock wLock = rwLock.writeLock();
	private int capacity;
	private Map<Integer, Employee> employees;

	public CompanyStreamImpl(int capacity) {
		employees = new HashMap<>();
		this.capacity = capacity;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		wLock.lock();
		try {
			if (employees.size() == capacity) {
				return false;
			}
			return employees.putIfAbsent(employee.getId(), employee) == null;
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public Employee removeEmployee(int id) {
		rLock.lock();
		try {
			return employees.remove(id);
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public Employee findEmployee(int id) {
		rLock.lock();
		try {
			return employees.get(id);
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public double totalSalary() {

		rLock.lock();
		try {
			return employees.values().stream().mapToDouble(Employee::calcSalary).sum();
		} finally {
			rLock.unlock();
		}

	}

	@Override
	public double totalSales() {
		
		 rLock.lock();
		try {
			return employees.values().stream().filter(employee -> employee instanceof SalesManager)
					.mapToDouble(employee -> ((SalesManager) employee).getSalesValue()).sum();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public int quantity() {
		rLock.lock();
		try {
			return employees.size();
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public void printEmployees() {
		rLock.lock();
		try {
			employees.values().forEach(e -> System.out.println(e));
		} finally {
			rLock.unlock();
		}

	}

	@Override
	// O(n)
	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		return findEmployeesByPredicate(e -> e.getHours() > hours);
	}

	@Override
	// O(n)
	public Employee[] findEmployeesSalaryBetween(int minSalary, int maxSalary) {
		Predicate<Employee> predicate = new Predicate<>() {

			@Override
			public boolean test(Employee e) {
				return e.calcSalary() >= minSalary && e.calcSalary() < maxSalary;
			}
		};
		return findEmployeesByPredicate(predicate);
	}

	// O(n)
	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
	
	rLock.lock();
	try {
		return employees.values().stream().filter(predicate).toArray(Employee[]::new);
	} finally {
		rLock.unlock();
	}
		
	}

}
