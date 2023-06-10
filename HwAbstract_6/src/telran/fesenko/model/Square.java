package telran.fesenko.model;

public class Square extends Shape {
	public Square(double type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public double calcArea() {
		return type * type;
	}

	public double calcPerimeter() {
		return type * 4;
	}

	@Override
	public String toString() {
		return "Square: " + super.toString();
	}

}
