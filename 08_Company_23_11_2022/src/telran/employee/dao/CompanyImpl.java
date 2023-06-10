package telran.employee.dao;


import telran.employee.model.Employee;
import telran.employee.model.SalesManenger;

public class CompanyImpl implements Company {
	private Employee[] employees;
	private int size;

	public CompanyImpl(int capacity) {
		employees = new Employee[capacity];
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (size == employees.length || findEmployee(employee.getId()) != null) {
			return false;
		}
		employees[size++] = employee;

		return true;

	}

	@Override
	public Employee removeEmployee(int id) {
		Employee res = null;
		if (findEmployee(id) != null && size >= 0) {

			for (int i = 0, y = 0; i < size; i++) {
				if (employees[i].getId() == id) {
					res = employees[size - 1 > 0 && i < size - 1 ? i++ : i];
				}
				if (employees[i].getId() != id) {
					employees[y++] = employees[i];
				}
			}
			employees[size--] = null;
		}
		return res;
	}

	@Override
	public Employee findEmployee(int id) {
		for (int i = 0; i < size; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		return null;
	}

	@Override
	public double totalSalary() {
		double res = 0;
		for (int i = 0; i < size; i++) {
			res += employees[i].calcSalary();
		}
		return res;
	}

	@Override
	public double totalSales() {
		double res = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i] instanceof SalesManenger) {

				SalesManenger sm = (SalesManenger) employees[i];
				res += sm.getSalesValue();
			}
		}
		return res;
	}

	@Override
	public int quantity() {
		return size;
	}

	@Override
	public double averageSalary() {
		double res = 0;
		for (int i = 0; i < size; i++) {
			res += employees[i].calcSalary();
		}
		return res / size;
	}

	@Override
	public void printEmployees() {
		for (int i = 0; i < size; i++) {
			System.out.println(employees[i]);
		}

	}

	@Override
	public Employee[] findEmployeesHoursGreaterThan(int hours) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i].getHours() > hours) {
				count++;
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (employees[i].getHours() > hours) {
				res[j++] = employees[i];
			}
		}
		return res;
	}

	@Override
	public Employee[] findEmployeesSalaryBetween(int minSalary, int maxSalari) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() <= maxSalari) {
				count++;
			}
		}
		Employee[] res = new Employee[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (employees[i].calcSalary() >= minSalary && employees[i].calcSalary() <= maxSalari) {
				res[j++] = employees[i];
			}
		}
		return res;
	}

}
