package telran.employee.controller;

import telran.employee.model.Employee;
import telran.util.service.TableInfoRunner;

public class EmployeeAppl {

	public static void main(String[] args) {
		TableInfoRunner.runInfo(Employee.class);

	}

}
