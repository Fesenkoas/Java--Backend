package telran.fesenko.model;

public class Triangle extends Shape {
	public Triangle(double type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public double calcArea() {
		double p1 = (type * 3) / 2;
		return Math.round(Math.sqrt(p1 * (p1 - type) * (p1 - type) * (p1 - type)));
	}

	public double calcPerimeter() {
		return type * 3;
	}

	@Override
	public String toString() {
		return "Triangle: " + super.toString();
	}

}
