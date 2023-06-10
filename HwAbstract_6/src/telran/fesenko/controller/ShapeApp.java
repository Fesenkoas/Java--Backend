package telran.fesenko.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import telran.fesenko.model.Circle;
import telran.fesenko.model.Shape;
import telran.fesenko.model.Square;
import telran.fesenko.model.Triangle;

public class ShapeApp {

	public static void main(String[] args) {
		Shape[] figure = new Shape[4];
		figure[0] = new Circle(8);
		figure[1] = new Circle(6);
		figure[2] = new Triangle(9);
		figure[3] = new Square(7);
		printArray(figure);
		System.out.println("Total Area = " + totalArea(figure));
		System.out.println("Total Perimeter = " + totalPerimeter(figure));
		System.out.println("Total Perimeter = " + totalPerimeter(figure));

		String regex = "Circle";
		System.out.println("Total " + regex + " = " + totalFigure(figure, regex));

	}

	private static void printArray(Shape[] figure) {
		for (int i = 0; i < figure.length; i++) {
			if (figure[i] != null) {
				System.out.println(figure[i]);
			}
		}
	}

	private static double totalArea(Shape[] figure) {
		double res = 0;
		for (int i = 0; i < figure.length; i++) {
			if (figure[i] != null) {
				res += figure[i].calcArea();
			}
		}
		return res;
	}

	private static double totalPerimeter(Shape[] figure) {
		double res = 0;
		for (int i = 0; i < figure.length; i++) {
			if (figure[i] != null) {
				res += figure[i].calcPerimeter();
			}
		}
		return res;
	}

	private static double totalFigure(Shape[] figure, String regex) {
		Pattern pattern = Pattern.compile(regex);
		double res = 0;
		for (int i = 0; i < figure.length; i++) {
			Matcher matcher = pattern.matcher(figure[i].toString());
			if (matcher.find()) {
				res += figure[i].calcArea();
			}
		}
		return res;
	}
}
