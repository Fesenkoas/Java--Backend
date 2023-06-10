package telran.set.person.model;

import java.util.Objects;

public class Person {
	final int id;
	String firstName;
	String lastName;

	public Person(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.id = id;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
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
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(firstName, lastName);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
//	}
//
//	@Override
//	public String toString() {
//		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
}
