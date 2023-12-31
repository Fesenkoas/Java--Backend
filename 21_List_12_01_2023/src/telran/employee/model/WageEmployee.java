package telran.employee.model;

public class WageEmployee extends Employee {
	private double wage;

	public WageEmployee(int id, String firstName, String lastName, int hours, double wage) {
		super(id, firstName, lastName, hours);
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double calcSalary() {
		return wage * hours;
	}
	@Override
	public String toString() {
		return super.toString()+ ", salary=" + calcSalary();
	}
}
