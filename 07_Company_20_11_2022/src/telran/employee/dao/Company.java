package telran.employee.dao;

import telran.employee.model.Employee;

public interface Company {
	
	
	boolean addEmployee(Employee employee);

	Employee removeEmployee(int id);

	Employee findEmployee(int id);

	double totalSalary();

	double totalSales();

	int quantity();

	double averageSalary();

	void printEmployees();

}
