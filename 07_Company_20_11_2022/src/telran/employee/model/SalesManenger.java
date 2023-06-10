package telran.employee.model;

public class SalesManenger extends Employee {
	private double salesValue;
	private double percent;

	public SalesManenger(int id, String firstName, String lastName, int hours, double salesValue, double percent) {
		super(id, firstName, lastName, hours);
		this.salesValue = salesValue;
		this.percent = percent;
	}

	public double getSalesValue() {
		return salesValue;
	}

	public void setSalesValue(double salesValue) {
		this.salesValue = salesValue;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public double calcSalary() {
		return salesValue * percent;
	}

	@Override
	public String toString() {
		return super.toString()+ ", salary=" + calcSalary();
	}
}
