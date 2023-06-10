package telran.supermarket.controller;

import java.time.LocalDate;

import telran.supermarket.dao.SuperMarketImpl;
import telran.supermarket.model.Product;

public class SuperMarketApp {

	public static void main(String[] args) {
		SuperMarketImpl supermarket = new SuperMarketImpl();

		supermarket.addProduct(new Product(1, "cola", "cat1", "cola", 10, LocalDate.of(2023, 01, 8)));
		supermarket.addProduct(new Product(2, "fanta", "cat2", "cola", 20, LocalDate.of(2023, 11, 22)));
		supermarket.addProduct(new Product(3, "mars", "cat3", "mars", 30, LocalDate.of(2023, 11, 30)));
		supermarket.addProduct(new Product(4, "snikers", "cat4", "snikers", 40, LocalDate.of(2023, 01, 12)));
		supermarket.addProduct(new Product(5, "twiks", "cat5", "twiks", 50, LocalDate.of(2023, 02, 4)));

		printProduct(supermarket.findProductWithExpDate());
	}

	private static void printProduct(Iterable<Product> supermarket) {
		System.out.println("===================");
		for (Product product : supermarket) {
			System.out.println(product);
		}
	}

}
