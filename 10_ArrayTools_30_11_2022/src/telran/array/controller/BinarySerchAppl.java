package telran.array.controller;

import telran.array.tools.ArrayTools;

public class BinarySerchAppl {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 5, 5, 7, 11, 11, 11, 13 };
		int index = ArrayTools.binarySearch(arr, 7);
		System.out.println(index);

	}

}
