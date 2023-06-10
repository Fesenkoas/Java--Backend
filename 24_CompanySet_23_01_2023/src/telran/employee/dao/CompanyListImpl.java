package telran.employee.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import telran.employee.model.Employee;
import telran.employee.model.SalesManenger;

public class CompanyListImpl implements Company {
	private List<Employee> employees;
	private int capacity;

	public CompanyListImpl(int capacity) {
		employees = new ArrayList<>();
		this.capacity = capacity;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (capacity == employees.size() || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees.add(employee);

		return true;
	}

	@Override
	public Employee removeEmployee(int id) {
		Employee vic = findEmployee(id);
		employees.remove(vic);
		return vic;
	}

	@Override
	public Employee findEmployee(int id) {
		for (Employee e : employees) {
			if (e.getId() == id) {
				return e;
			}
		}
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
		double res = 0;
		for (Employee e : employees) {
			if (e instanceof SalesManenger) {

				SalesManenger sm = (SalesManenger) e;
				res += sm.getSalesValue();
			}
		}
		return res;
	}

	@Override
	public int quantity() {
		// TODO Auto-generated method stub
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
