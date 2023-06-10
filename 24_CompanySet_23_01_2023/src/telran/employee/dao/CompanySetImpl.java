package telran.employee.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import telran.employee.model.Employee;

public class CompanySetImpl implements Company {
	private Set<Employee> employees;
	private int capacity;

	public CompanySetImpl(int capacity) {
		employees = new HashSet<>();
		this.capacity = capacity;
	}
	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee removeEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double totalSalary() {
		double res = 0;
		for (Employee e : employees) {
			res += e.calcSalary();
		}
		return res;
	}

	@Override
	public double totalSales() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int quantity() {
		return employees.size();
	}

	@Override
	public void printEmployees() {
		for (Employee e : employees) {
			System.out.println(e);
		}

	}

	@Override
	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		// Predicate<Employee> predicate = e -> e.getHours()>hours;

		return findEmployeesByPredicate(e -> e.getHours() > hours);
	}

	@Override
	public Employee[] findEmployeesSalaryBetween(int minSalary, int maxSalary) {

		Predicate<Employee> predicate = (Employee e) -> {
			return e.calcSalary() >= minSalary && e.calcSalary() < maxSalary;
		};
		return findEmployeesByPredicate(predicate);
	}

	private Employee[] findEmployeesByPredicate(Predicate<Employee> predicate) {
		List<Employee> res = new ArrayList<>();
		for (Employee e : employees) {
			if (predicate.test(e)) {
				res.add(e);
			}
		}
		
		return res.toArray(new Employee[res.size()]);

	}

}
