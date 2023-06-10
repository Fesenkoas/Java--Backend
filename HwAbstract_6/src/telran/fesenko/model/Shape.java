package telran.fesenko.model;

public abstract class Shape {
	protected double type;

	public Shape(double type) {
		super();
		this.type = type;
	}

	public double getType() {
		return type;
	}

	public void setType(double type) {
		this.type = type;
	}

	public abstract double calcArea();

	public abstract double calcPerimeter();

	@Override
	public String toString() {
		return "Shape type = " + type + ", Area = " + calcArea() + ", Perimeter = " + calcPerimeter();
	}

}
