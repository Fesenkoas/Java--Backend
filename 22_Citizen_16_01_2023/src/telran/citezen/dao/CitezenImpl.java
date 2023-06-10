package telran.citezen.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import telran.citezen.interfaces.Citezen;
import telran.citezen.model.Person;

public class CitezenImpl implements Citezen {

	List<Person> idList;
	List<Person> lastNameList;
	List<Person> ageList;
	private static Comparator<Person> lastNameComp;
	private static Comparator<Person> ageComp;
//	private static Comparator<Person> lastNameComp = new Comparator<Person>() {
//		
//		public int compare(Person p1, Person p2) {
//			return p1.getLastName().compareTo(p2.getLastName());
//		}
//	};
//	private static Comparator<Person> lastNameComp = (p1, p2) -> {
//		int res = p1.getLastName().compareTo(p2.getLastName());
//		return res != 0 ? res : p1.compareTo(p2);
//	};
//	private static Comparator<Person> ageComp = new Comparator<Person>() {
//
//		public int compare(Person p1, Person p2) {
//			return p1.getAge() - p2.getAge();
//		}
//	};

//	private static Comparator<Person> ageComp = (p1, p2) -> {
//		int res = p1.getAge() - p2.getAge();
//		return res != 0 ? res : p1.compareTo(p2);
//	};

	static {
		lastNameComp = (p1, p2) -> {
			int res = p1.getLastName().compareTo(p2.getLastName());
			return res != 0 ? res : p1.compareTo(p2);
		};
		ageComp = (p1, p2) -> {
			int res = p1.getAge() - p2.getAge();
			return res != 0 ? res : p1.compareTo(p2);
		};
	}

	public CitezenImpl() {
		idList = new ArrayList<Person>();
		lastNameList = new ArrayList<Person>();
		ageList = new ArrayList<Person>();
	}

//O(q)
	public CitezenImpl(List<Person> citizens) {
		this();
		for (Person p : citizens) {
			add(p);
		}
	}

//O(n log(n))
	// O(n)
	@Override
	public boolean add(Person person) {
		if (person == null) {
			return false;
		}
		int index = Collections.binarySearch(idList, person);
		if (index >= 0) {
			return false;
		}
		index = -index - 1;
		idList.add(index, person);
		index = -Collections.binarySearch(ageList, person, ageComp) - 1;
		ageList.add(index, person);
		index = -Collections.binarySearch(lastNameList, person, lastNameComp) - 1;
		lastNameList.add(index, person);
		return true;
//		if (idList.contains(person) || person == null) {
//			return false;
//		}
//		idList.add(person);
//		lastNameList.add(person);
//		ageList.add(person);
//		Collections.sort(lastNameList, lastNameComp);
//		Collections.sort(ageList, ageComp);
//		return true;
	}

	@Override
	// O(n)
	public boolean remove(int id) {
		Person victim = find(id);
		if (victim == null) {
			return false;
		}
		idList.remove(victim);
		lastNameList.remove(victim);
		ageList.remove(victim);
//		for (int i = 0; i < idList.size(); i++) {
//			if (idList.get(i).getId() == id) {
//				idList.remove(i);
//				lastNameList.remove(i);
//				ageList.remove(i);
//				return true;
//			}
//		}
		return true;
	}

	@Override
	// O(log(n))
	public Person find(int id) {
		int index = Collections.binarySearch(idList, new Person(id, null, null, null));
		return index < 0 ? null : idList.get(index);
//		for (Person p : idList) {
//			if (p.getId() == id) {
//				return p;
//			}
//		}
//		return null;

	}

	@Override
	// 0(log(n))???
	public Iterable<Person> find(LocalDate minAge, LocalDate maxAge) {

		Person pattern = new Person(Integer.MIN_VALUE, "", "", minAge);
		int from = -Collections.binarySearch(ageList, pattern, ageComp) - 1;
		pattern = new Person(Integer.MAX_VALUE, "", "", maxAge);
		int to = -Collections.binarySearch(ageList, pattern, ageComp) - 1;
		return ageList.subList(from, to);

//		int start = -1;
//		int end = -1;
//		for (int i = 0; i < ageList.size(); i++) {
//			if (ageList.get(i).getAge() >= minAge && ageList.get(i).getAge() <= maxAge) {
//				if (start == -1)
//					start = i;
//				end = i;
//			}
//		}
//		if (start == -1)
//			return new ArrayList<Person>();
//		else
//			return ageList.subList(start, end + 1);
	}

	@Override
	// 0(log(n))???
	public Iterable<Person> find(String lastName) {
		
		Person pattern = new Person(Integer.MIN_VALUE, "", lastName,null);
		int from = -Collections.binarySearch(lastNameList, pattern, lastNameComp) - 1;
		pattern = new Person(Integer.MAX_VALUE, "", lastName, null);
		int to = -Collections.binarySearch(lastNameList, pattern, lastNameComp) - 1;

		return lastNameList.subList(from, to);

//		int start = -1;
//		int end = -1;
//		// int index = Collections.binarySearch(lastNameList, new Person(0,null,
//		// lastName, 0), lastNameComp);
//		for (int i = 0; i < lastNameList.size(); i++) {
//			if (lastNameList.get(i).getLastName().equals(lastName)) {
//				if (start == -1)
//					start = i;
//				end = i;
//			}
//		}
//		if (start == -1)
//			return new ArrayList<Person>();
//		else
//			return lastNameList.subList(start, end + 1);
	}

	@Override
	// 0(1)
	public Iterable<Person> getAllPersonSortedById() {
		return idList;
	}

	@Override
	// 0(1)
	public Iterable<Person> getAllPersonSortedByLastName() {
		return lastNameList;
	}

	@Override
	// 0(1)
	public Iterable<Person> getAllPersonSortedByAge() {
		return ageList;
	}

	@Override
	// 0(1)
	public int size() {
		return idList.size();
	}

}
