package fesenko.cars.model;

import java.util.Objects;

public class Car {
private String regNumber;
private String model;
private String company;
private String color;
private double engine;

public Car(String regNumber, String model, String company, String color, double engine) {
	super();
	this.regNumber = regNumber;
	this.model = model;
	this.company = company;
	this.color = color;
	this.engine = engine;
}

public String getRegNumber() {
	return regNumber;
}

public void setRegNumber(String regNumber) {
	this.regNumber = regNumber;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getModel() {
	return model;
}

public String getCompany() {
	return company;
}

public double getEngine() {
	return engine;
}

@Override
public String toString() {
	return "Cars [getRegNumber()=" + getRegNumber() + ", getColor()=" + getColor() + ", getModel()=" + getModel()
			+ ", getCompany()=" + getCompany() + ", getEngine()=" + getEngine() + "]";
}

@Override
public int hashCode() {
	return Objects.hash(regNumber);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Car other = (Car) obj;
	return Objects.equals(regNumber, other.regNumber);
}



}
