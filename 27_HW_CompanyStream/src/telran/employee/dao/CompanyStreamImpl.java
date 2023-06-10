package telran.employee.dao;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.employee.model.Employee;
import telran.employee.model.SalesManager;

public class CompanyStreamImpl implements Company {
	private int capacity;
	private Map<Integer, Employee> employees;

	public CompanyStreamImpl(int capacity) {
		employees = new HashMap<>();
		this.capacity = capacity;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employees.size() == capacity) {
			return false;
		}
		return employees.putIfAbsent(employee.getId(), employee) == null;
	}

	@Override
	public Employee removeEmployee(int id) {
		return employees.remove(id);
	}

	@Override
	public Employee findEmployee(int id) {
		return employees.get(id);
	}

	@Override
	public double totalSalary() {

		return employees.values().stream()
				.mapToDouble(Employee::calcSalary)
				.sum();

	}

	@Override
	public double totalSales() {
		
		 return employees.values().stream()
			        .filter(employee -> employee instanceof SalesManager)
			        .mapToDouble(employee -> ((SalesManager) employee).getSalesValue())
			        .sum();
	}

	@Override
	public int quantity() {
		return employees.size();
	}

	@Override
	public void printEmployees() {
		employees.values().forEach(e -> System.out.println(e));

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
	
	return employees.values().stream()
						.filter(predicate)
						.toArray(Employee []:: new);
		
	}

}
