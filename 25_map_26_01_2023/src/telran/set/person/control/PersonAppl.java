package telran.set.person.control;

import java.util.HashSet;
import java.util.Set;

import telran.set.person.model.Person;

public class PersonAppl {

	public static void main(String[] args) {
		Person john = new Person("John", "Smith", 1);
		Person mary = new Person("Mary", "Jackson", 2);
		Set<Person> persons = new HashSet<>();
		persons.add(john);
		persons.add(mary);
		System.out.println(persons.contains(john));
		System.out.println(persons.contains(mary));
		System.out.println("==========================");
		mary.setLastName("Smith");
		System.out.println(persons.contains(john));
		System.out.println(persons.contains(mary));
		System.out.println("==========================");
		System.out.println(persons.size());
		persons.forEach(p->System.out.println(p));

	}

}
