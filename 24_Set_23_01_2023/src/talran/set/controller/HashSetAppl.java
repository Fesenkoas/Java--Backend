package talran.set.controller;

import java.util.HashSet;
import java.util.Set;

public class HashSetAppl {

	public static void main(String[] args) {


	Set<String> mySet = new HashSet<>();
	System.out.println(mySet.size());
	mySet.add("Boston");
	mySet.add("Atlanta");
	mySet.add("Chicago");
	mySet.add("New York");
	mySet.add("Detroid");
	System.out.println(mySet.size());
	mySet.add("Chicago");
	System.out.println(mySet.size());
	System.out.println(mySet.contains("Chicago"));
	System.out.println(mySet.contains("Dallas"));
	for (String string : mySet) {
		System.out.println(string);
	}

	}

}
