package telran.fesenko.model;

public class Circle extends Shape {

	public Circle(double type) {
		super(type);
	}

	public double calcArea() {
		return Math.round(Math.PI * (type * type));
	}

	public double calcPerimeter() {
		return Math.round(type * Math.PI);
	}

	@Override
	public String toString() {
		return "Circle: " + super.toString();
	}

}
