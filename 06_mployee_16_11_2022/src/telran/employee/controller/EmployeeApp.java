package telran.employee.controller;

import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManenger;
import telran.employee.model.WageEmployee;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee[] firm = new Employee[5];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 20);
		firm[1] = new WageEmployee(2000, "Ann", "Smith", 182, 40);
		firm[2] = new SalesManenger(3000, "Piter", "Jackson", 182, 40000, 0.1);
		firm[3] = new SalesManenger(4000, "Tigran", "Petrosyn", 91, 80000, 0.1);
		printArray(firm);
		double total = totalSalary(firm);
		System.out.println("Total salary = " + total);


		double totalSales = totalSales(firm);
		System.out.println("Total sales = " + totalSales );
	}
private static double totalSales(Employee[] firm) {
	double res = 0;
	
	for (int i = 0; i < firm.length; i++) {
		if (firm[i]instanceof SalesManenger) {
			
				SalesManenger sm = (SalesManenger) firm[i];
				res += sm.getSalesValue();
		}
	}
	return res;
}
	
	private static double totalSalary(Employee[] firm) {
		double res = 0;
		for (int i = 0; i < firm.length; i++) {
			if (firm[i] != null) {
				res += firm[i].calcSalary();
			}
		}
		return res;
	}

	private static void printArray(Employee[] firm) {
		for (int i = 0; i < firm.length; i++) {
			if (firm[i] != null) {
				System.out.println(firm[i]);
			}
		}
	}

}
