package telran.employee.model;

import java.time.LocalDate;
import telran.util.annotation.id;
import telran.util.annotation.index;
import telran.util.annotation.Table;

@Table
public class Employee {
	@id
	@index(unique=true)
	int id;
	@index
	String name;
	@index
	int salary;
	@index
	LocalDate birthday;

	public Employee() {
	}

	public Employee(int id, String name, int salary, LocalDate birthday) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public int getId() {
		return id;
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
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", birthday=" + birthday + "]";
	}

}
