package fesenko.cars.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fesenko.cars.dao.Garage;
import fesenko.cars.dao.GarageImpl;
import fesenko.cars.model.Car;

class GarageTest {
	Garage garage;
	Car[] car;

	@BeforeEach
	void setUp() throws Exception {
		garage = new GarageImpl(5);

		car = new Car[4];
		car[0] = new Car("IL20345566", "ML350", "Mercedes-Benz", "black", 2.2);
		car[1] = new Car("AO2345567IB", "RCZ", "Peugeot", "yellow", 1.2);
		car[2] = new Car("AA545666OO", "R1150GS ADVENTURE", "BMW", "black", 2.2);
		car[3] = new Car("IL000001", "BROOKLANDS", "Bentley", "white", 4.0);
		for (int i = 0; i < car.length; i++) {
			garage.addCar(car[i]);
		}
	}

	@Test
	void testAddCar() {
		assertFalse(garage.addCar(car[1]));
		Car newCar = new Car("IL000007", "RS4", "Audi", "white", 4.0);
		assertTrue(garage.addCar(newCar));
		assertEquals(5, garage.quantity());
		assertFalse(garage.addCar(new Car("IL000010", "S80", "Volvo", "green", 2.0)));
	}

	@Test
	void testRemoveCar() {
		assertNull(garage.removeCar("0000000"));
		assertEquals(4, garage.quantity());
		assertEquals(car[1], garage.removeCar("AO2345567IB"));
		assertEquals(3, garage.quantity());
	}

	@Test
	void testFindCarByRegNumber() {
	assertEquals(car[2], garage.findCarByRegNumber("AA545666OO"));
	assertNull(garage.findCarByRegNumber("0000000"));
	}

	@Test
	void testFindCarsByModel() {
		Car[] actual = garage.findCarsByModel("R1150GS ADVENTURE");
		Car[] expected = { car[2] };
		assertArrayEquals(expected, actual);
		actual = garage.findCarsByModel("S80");
		expected = new Car[0];
		assertArrayEquals(expected, actual);
	}

	@Test
	void testFindCarsByCompany() {
		Car[] actual = garage.findCarsByCompany("BMW");
		Car[] expected = { car[2] };
		assertArrayEquals(expected, actual);
		actual = garage.findCarsByCompany("Volvo");
		expected = new Car[0];
		assertArrayEquals(expected, actual);
	}

	@Test
	void testFindCarsByEngine() {
		Car[] actual = garage.findCarsByEngine(1.2, 2.2);
		Car[] expected = { car[0], car[1], car[2] };
		assertArrayEquals(expected, actual);

	}

	@Test
	void testFindCapsByColor() {
		Car[] actual = garage.findCarsByColor("black");
		Car[] expected = { car[0], car[2] };
		assertArrayEquals(expected, actual);
		actual = garage.findCarsByColor("green");
		expected = new Car[0];
		assertArrayEquals(expected, actual);
	}

	@Test
	void testQuantity() {
		assertEquals(4, garage.quantity());
	}

	@Test
	void testPrintEmployees() {
		garage.printCars();
	}

}
