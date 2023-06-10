package telran.employee.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.employee.dao.Company;
import telran.employee.dao.CompanyImpl;
import telran.employee.model.Employee;
import telran.employee.model.Manager;
import telran.employee.model.SalesManenger;
import telran.employee.model.WageEmployee;

class CompanyTest {
	Company company;
	Employee[] firm;

	@BeforeEach
	void setUp() throws Exception {
		company = new CompanyImpl(5);
		firm = new Employee[4];
		firm[0] = new Manager(1000, "John", "Smith", 182, 20000, 20);
		firm[1] = new WageEmployee(2000, "Ann", "Smith", 182, 40);
		firm[2] = new SalesManenger(3000, "Peter", "Jackson", 182, 40000, 0.1);
		firm[3] = new SalesManenger(4000, "Tigran", "Petrosyan", 91, 80000, 0.1);
		for (int i = 0; i < firm.length; i++) {
			company.addEmployee(firm[i]);
		}
	}

	@Test
	void testAddEmployee() {
		assertFalse(company.addEmployee(firm[1]));
		Employee empl = new SalesManenger(5000, "Tigran", "Petrosyan", 91, 80000, 0.1);
		assertTrue(company.addEmployee(empl));
		assertFalse(company.addEmployee(new SalesManenger(6000, "Tigran", "Petrosyan", 91, 80000, 0.1)));
	}

	@Test
	void testRemoveEmployee() {
		assertEquals(firm[3], company.removeEmployee(4000));
		assertNotEquals(firm[3], company.removeEmployee(0000));
		//company.printEmployees();
	}

	@Test
	void testFindEmployee() {
		assertEquals(firm[3], company.findEmployee(4000));
		assertNotEquals(firm[3], company.findEmployee(3000));
	}

	@Test
	void testTotalSalary() {
		assertEquals(42920.0, company.totalSalary());
		assertNotEquals(0, company.totalSalary());
	}

	@Test
	void testTotalSales() {
		assertEquals(120000.0, company.totalSales());
		assertNotEquals(0, company.totalSales());
	}

	@Test
	void testQuantity() {
		assertEquals(4, company.quantity());
	}

	@Test
	void testAverageSalary() {
		assertEquals(10730.0, company.averageSalary());
		assertNotEquals(0, company.averageSalary());
	}

//	@Test
//	void testPrintEmployees() {
//		company.printEmployees();
//	}

}
