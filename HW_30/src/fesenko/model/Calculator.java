package fesenko.model;

public class Calculator {
	public void minus(String str) {
		System.out.println("f1 " + str);
	}

	public void add(String num, String num1) {
		try {
			
			double i = Double.parseDouble(num);
			double x = Double.parseDouble(num1);
			System.out.println("result = "+(i+x));
		} catch (NumberFormatException e) {
		    System.out.println("Невозможно преобразовать строку в число");
		}
		
	}
	public void subtract(String num, String num1) {
		try {
			double i = Double.parseDouble(num);
			double x = Double.parseDouble(num1);
			System.out.println("result = "+(i-x));
		} catch (NumberFormatException e) {
		    System.out.println("Невозможно преобразовать строку в число");
		}
		
	}
	public void multiplication(String num, String num1) {
		try {
			
			double i = Double.parseDouble(num);
			double x = Double.parseDouble(num1);
			System.out.println("result = "+(i*x));
		} catch (NumberFormatException e) {
		    System.out.println("Невозможно преобразовать строку в число");
		}
		
	}
}
