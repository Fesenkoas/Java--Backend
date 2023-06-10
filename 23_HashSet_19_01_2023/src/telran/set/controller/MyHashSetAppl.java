package telran.set.controller;

import telran.set.interfese.ISet;
import telran.set.model.MyHashSet;

public class MyHashSetAppl {

	public static void main(String[] args) {
		ISet<String> mySet = new MyHashSet<>();
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
