package telran.array.tools;

import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayTools {
	
	public static void printArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("================");
	}

	public static <T> T findFirstByPredicate(T[] arr, Predicate<T> predicate) {
		for (int i = 0; i < arr.length; i++) {
			if (predicate.test(arr[i])) {
				return arr[i];
			}
		}
		return null;
	}

	public static <T extends Comparable<T>> void bubbleSortNum(T[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareTo(arr[i + 1]) == 0) {
					T res = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = res;

				}
				
			}

		}
	}
	
	public static <T > void bubbleSortNum(T[] arr, Comparator<T> comp) {
		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (comp.compare(arr[i], arr[i+1]) > 0) {
					T res = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = res;

				}
				
			}

		}
	}

	public static int  binarySearch(int[] arr, int value) {
		int l =0;
		int r =arr.length-1;
		while(l<=r) {
			int  mid = (l+r)/2;
			if(arr[mid]==value) {return mid;}
			if(value< arr[mid]) {
				r = mid -1;
			}else {l = mid+1;}
		}
		return -l-1;
	}
	
}
