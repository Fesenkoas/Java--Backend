package telran.programmer.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import telran.programmer.model.Programmer;

public class ProgrammerAppl {

	public static void main(String[] args) {
		List<Programmer> programmer = getProgrammer();
		System.out.println("==== Most Skilled ====");
		printMostSkilled(programmer);
		System.out.println("==== Most Technologies ====");
		printMostTech(programmer);

	}

	private static void printMostTech(List<Programmer> programmer) {
		System.out.println("====See All====");
		Iterable<String> techfrequency = programmer.stream()
													.map(p -> p.getTech())
													.flatMap(t -> Arrays.stream(t))
													.collect(Collectors.toList());
		StreamSupport.stream(techfrequency.spliterator(), false).distinct().forEach(System.out::println);
		System.out.println("==== Map ====");
		Map<String, Long> techfrequency1 = programmer.stream()
				.map(p -> p.getTech())
				.flatMap(t -> Arrays.stream(t))
				.collect(Collectors.groupingBy(t->t,Collectors.counting()));
		//System.out.println(techfrequency1);
		Long maxTech = techfrequency1.values().stream().max(Long::compareTo).orElse(null);
		if(maxTech!=null) techfrequency1.entrySet().stream().filter(e-> maxTech.equals(e.getValue())).forEach(e-> System.out.println(e.getKey()));
	}

	private static void printMostSkilled(List<Programmer> programmer) {
		Map<Integer, List<Programmer>> skilledProg = programmer.stream()
				.collect(Collectors.groupingBy(p -> p.getTech().length));
		// skilledProg.forEach((k, v) -> System.out.println(k + "=" + v));
		Integer maxTech = skilledProg.keySet().stream().max(Integer::compareTo).orElse(null);
		if(maxTech != null) skilledProg.get(maxTech).forEach(System.out::println);

	}

	private static List<Programmer> getProgrammer() {

		return List.of(new Programmer("Peter", "C++", "Pyton", "Java", "Go"), new Programmer("Moshe", "Pyton", "Java"),
				new Programmer("Sarah", "Kotlin", "Scala", "Java", "JavaScript"), new Programmer("Jacob", "Java", "Go"),
				new Programmer("Petrovich", "Fortran", "Algol", "PL-1"));
	}

}
