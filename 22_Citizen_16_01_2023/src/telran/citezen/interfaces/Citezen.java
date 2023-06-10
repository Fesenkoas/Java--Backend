package telran.citezen.interfaces;

import java.time.LocalDate;

import telran.citezen.model.Person;

public interface Citezen {
	boolean add(Person person);
	boolean remove(int id);
	Person find(int id);
	//Iterable<Person> find(int minAge, int maxAge);
	Iterable<Person> find(String lastName);
	Iterable<Person> getAllPersonSortedById();
	Iterable<Person> getAllPersonSortedByAge();
	Iterable<Person> getAllPersonSortedByLastName();
	int size();
	Iterable<Person> find(LocalDate minAge, LocalDate maxAge);
}
