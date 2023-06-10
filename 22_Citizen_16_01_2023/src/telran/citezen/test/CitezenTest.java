package telran.citezen.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.citezen.dao.CitezenImpl;
import telran.citezen.interfaces.Citezen;
import telran.citezen.model.Person;

class CitezenTest {
	Citezen citizens;

	@BeforeEach
	void setUp() throws Exception {
		citizens = new CitezenImpl(List.of(new Person(1, "Peter", "Jackson", LocalDate.of(1990, 2, 16)),
				new Person(2, "John", "Smith", LocalDate.of(1982, 10, 22)),
				new Person(3, "Mary", "Jackson", LocalDate.of(1990, 1, 11)),
				new Person(4, "Tigran", "Petrosian", LocalDate.of(1996, 5, 6))));
	}

	@Test
	void testCitizensImplListOfPerson() {
		citizens = new CitezenImpl(List.of(new Person(1, "Peter", "Jackson", LocalDate.of(1990, 2, 16)),
				new Person(1, "Rabindranat", "Smith", LocalDate.of(1990, 2, 15))));
		assertEquals(1, citizens.size());
	}

	@Test
	void testAdd() {
		assertFalse(citizens.add(null));
		assertFalse(citizens.add(new Person(2, "John", "Smith", LocalDate.of(1982, 10, 22))));
		assertEquals(4, citizens.size());
		assertTrue(citizens.add(new Person(5, "John", "Smith", LocalDate.of(1999, 4, 30))));
		assertEquals(5, citizens.size());
	}

	@Test
	void testRemove() {
		assertFalse(citizens.remove(5));
		assertEquals(4, citizens.size());
		assertTrue(citizens.remove(2));
		assertEquals(3, citizens.size());
	}

	@Test
	void testFindId() {
		Person person = citizens.find(1);
		assertEquals(1, person.getId());
		assertEquals("Peter", person.getFirstName());
		assertEquals("Jackson", person.getLastName());
		assertEquals(32, person.getAge());
		assertNull(citizens.find(5));
	}

	@Test
	void testFindAge() {
		LocalDate dateStart = LocalDate.of(1990, 1, 1);
		LocalDate dateEnd = LocalDate.of(1996, 6, 6);
		Iterable<Person> res = citizens.find(dateEnd, dateStart);

		List<Person> actual = new ArrayList<>();
		for (Person person : res) {
			actual.add(person);
		}
		Collections.sort(actual);
		List<Person> expected = List.of(new Person(1, "Peter", "Jackson", LocalDate.of(1990, 1, 11)),
				new Person(3, "Mary", "Jackson", LocalDate.of(1996, 5, 6)),
				new Person(4, "Tigran", "Petrosian", LocalDate.of(1996, 5, 6)));

		assertIterableEquals(expected, actual);
	}

	@Test
	void testFindName() {
		Iterable<Person> res = citizens.find("Jackson");
		List<Person> actual = new ArrayList<>();
		for (Person person : res) {
			actual.add(person);
		}
		Collections.sort(actual);
		List<Person> expected = List.of(new Person(1, "Peter", "Jackson", LocalDate.of(1990, 1, 11)),
				new Person(3, "Mary", "Jackson", LocalDate.of(1996, 5, 6)));
		assertIterableEquals(expected, actual);
	}

	@Test
	void testGetAllPersonSortedById() {
		Iterable<Person> res = citizens.getAllPersonSortedById();
		int id = 0;
		for (Person person : res) {
			assertTrue(person.getId() > id);
			id = person.getId();
		}
	}

	@Test
	void testGetAllPersonSortedByLastName() {
		Iterable<Person> res = citizens.getAllPersonSortedByLastName();
		String lastName = "";
		for (Person person : res) {
			assertTrue(person.getLastName().compareTo(lastName) >= 0);
			lastName = person.getLastName();
		}
	}

	@Test
	void testGetAllPersonSortedByAge() {
		Iterable<Person> res = citizens.getAllPersonSortedByAge();
		int age = 0;
		for (Person person : res) {
			assertTrue(person.getAge() >= age);
			age = person.getAge();
		}
	}

	@Test
	void testSize() {
		assertEquals(4, citizens.size());
	}

}