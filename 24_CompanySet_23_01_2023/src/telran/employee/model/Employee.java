package telran.employee.model;

public abstract class Employee {
	protected final int id;
	protected String firstName;
	protected String lastName;
	protected int hours;

	public Employee(int id, String firstName, String lastName, int hours) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hours = hours;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public abstract double calcSalary();

	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hours=" + hours + ", salary="
				+ calcSalary();
	}

}
