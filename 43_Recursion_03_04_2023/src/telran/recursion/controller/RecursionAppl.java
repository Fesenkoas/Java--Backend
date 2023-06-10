package telran.recursion.controller;

import java.util.Arrays;

public class RecursionAppl {

	public static void main(String[] args) {
		int res = factorial(5);
		System.out.println(res);
		res = factorialRecursia(5);
		System.out.println(res);
		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
		res = binarySearch(arr, 17);
		System.out.println(res);
		res = binarySearchRecursia(arr, 17, 0, arr.length-1);
		System.out.println(res);
		res = power(3, 4);
		System.out.println(res);
		res = sumArr(arr, 0);
		System.out.println(res);
		reverseArr(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void reverseArr(int[] arr, int start, int end) {
	    if (start >= end) {
	        return;
	    }
	    int temp = arr[start];
	    arr[start] = arr[end];
	    arr[end] = temp;
	    reverseArr(arr, start + 1, end - 1);
	}
	
	public static int sumArr(int[] arr, int index) {
	    if (index == arr.length - 1) {
	        return arr[index];
	    }
	    else {
	        return arr[index] + sumArr(arr, index + 1);
	    }
	}

	public static int factorial(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	public static int binarySearch(int[] arr, int val) {
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] == val)
				return mid;
			if (val < arr[mid])
				r = mid - 1;
			else
				l = mid + 1;

		}
		return -l - 1;
	}

	public static int binarySearchRecursia(int[] arr, int val, int l, int r) {
		if (l > r)
			return -l - 1;
		int mid = (l + r) / 2;
		if (arr[mid] == val)
			return mid;
		if (val < arr[mid])
			return binarySearchRecursia(arr, val, l, mid - 1);
		else
			return binarySearchRecursia(arr, val, mid + 1, r);

	}
	public static int power(int n, int m) {
	    if (m == 0) {
	        return 1;
	    }
	    else {
	        return n * power(n, m-1);
	    }
	}

	public static int factorialRecursia(int n) {

		return n == 0 ? 1 : n * factorialRecursia(n - 1);
	}
}
