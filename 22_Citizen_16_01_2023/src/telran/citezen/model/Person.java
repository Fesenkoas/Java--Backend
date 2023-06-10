package telran.citezen.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Person implements Comparable<Person> {
	int id;
	String firstName;
	String lastName;
	LocalDate dateBirthday;


	public Person(int id, String firstName, String lastName, LocalDate dateBirthday) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirthday = dateBirthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		LocalDate newDate = LocalDate.now();
		return (int) ChronoUnit.YEARS.between(dateBirthday,newDate);
	}

	public void setdateBirthday(LocalDate dateBirthday) {
		this.dateBirthday = dateBirthday;
	}

	@Override
	public int compareTo(Person o) {
		return Integer.compare(id, o.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + this.getAge() + "]";
	}

}
