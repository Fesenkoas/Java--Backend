package emloeeyAppl;
import java.io.Serializable;
import java.time.LocalDate;

public class Emploeey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	LocalDate birthDay;
	double salary;
	Address address;
	
	public Emploeey(int id, String name, LocalDate birthDay, double salary, Address address) {
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.salary = salary;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public double getSalary() {
		return salary;
	}
	public Address getAddress() {
		return address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Emploeey)) {
			return false;
		}
		Emploeey other = (Emploeey) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Emploeey [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", salary=" + salary + ", address="
				+ address + "]";
	}
	
}
