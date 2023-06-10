package fesenko.cars.dao;

import java.util.function.Predicate;

import fesenko.cars.model.Car;

public class GarageImpl implements Garage {
	private Car[] cars;
	private int size;

	public GarageImpl(int capacity) {
		cars = new Car[capacity];
	}

	@Override
	public boolean addCar(Car car) {
		if (size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
			return false;
		}
		cars[size++] = car;

		return true;
	}

	@Override
	public Car removeCar(String regNumber) {
		
		Car res = null;
		if (findCarByRegNumber(regNumber) != null && size >= 0) {

			for (int i = 0, y = 0; i < size; i++) {
				if (cars[i].getRegNumber().equals(regNumber)) {
					res = cars[size - 1 > 0 && i < size - 1 ? i++ : i];
				}
				if (!cars[i].getRegNumber().equals(regNumber)) {
					cars[y++] = cars[i];
				}
			}
			cars[size--] = null;
		}
		return res;
	}

	@Override
	public Car findCarByRegNumber(String regNumber) {

		return findCarByPredicateRegNumber(c -> c.getRegNumber().equals(regNumber));

	}

	@Override
	public Car[] findCarsByModel(String model) {

		return findCarsByPredicate(c -> c.getModel().equals(model));

	}

	@Override
	public Car[] findCarsByCompany(String company) {

		return findCarsByPredicate(c -> c.getCompany().equals(company));

	}

	@Override
	public Car[] findCarsByEngine(double min, double max) {

		return findCarsByPredicate(c -> c.getEngine() >= min && c.getEngine() <= max);
		
	}

	@Override
	public Car[] findCarsByColor(String color) {

		return findCarsByPredicate(c -> c.getColor().equals(color));
	}

	private Car[] findCarsByPredicate(Predicate<Car> predicate) {
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (predicate.test(cars[i])) {
				count++;
			}
		}
		Car[] res = new Car[count];
		for (int i = 0, j = 0; j < res.length; i++) {
			if (predicate.test(cars[i])) {
				res[j++] = cars[i];
			}
		}
		return res;
	}

	private Car findCarByPredicateRegNumber(Predicate<Car> predicate) {
		
		for (int i = 0; i < size; i++) {
			if (predicate.test(cars[i])) {
				return cars[i];
			}
		}
		return null;
	}

	@Override
	public int quantity() {
		return size;

	}

	@Override
	public void printCars() {
		for (int i = 0; i < size; i++) {
			System.out.println(cars[i]);
		}

	}

}
