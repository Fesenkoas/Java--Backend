package telran.comporator.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.comporator.model.Wardrop;

class CaomporatorTest {
	private static final int SIZE = 10;
	private static final int MAX = 5;
	Wardrop[] arr;
	static Random random = new Random();

	@BeforeEach
	void setUp() throws Exception {
		arr = getWardrobes();
	}

	private Wardrop[] getWardrobes() {
		Wardrop[] res = new Wardrop[SIZE];
		for (int i = 0; i < res.length; i++) {
			double height = 1 + random.nextInt(MAX);
			double width = 1 + random.nextInt(MAX);
			double depth = 1 + random.nextInt(MAX);
			res[i] = new Wardrop(height, width, depth);
		}
		return res;
	}

	 private void printArray(Wardrop[] arr, String title) {
		 System.out.println("==="+title+"===");
		 for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	 }
	 
//	 @Test
//	 void testComparble(){
//		 printArray(arr, "Test comparble befor");
//		 Arrays.sort(arr);
//		 printArray(arr, "Test comparble after");
//		 int index = Arrays.binarySearch(arr, new Wardrop(2, 4, 1));
//		 System.out.println("index = "+ index);
//	 }
	 
//	 @Test
//	 void testComparator() {
//		 printArray(arr, "Test comparble befor");
//		Comparator<Wardrop> comp = (w1,w2) -> Double.compare(w1.area(), w2.area());
//		Arrays.sort(arr, comp);
//		 printArray(arr, "Test comparator after");
//		 int index = Arrays.binarySearch(arr, new Wardrop(2, 4, 1),comp);
//		 System.out.println("index = "+ index);
//	 }
	 
//	 @Test
//	 void testVolumeComparator() {
//		 printArray(arr, "Test volume comparble befor");
//			Comparator<Wardrop> comp = (w1,w2) -> Double.compare(w1.volume(), w2.volume());
//			Arrays.sort(arr, comp);
//			 printArray(arr, "Test volume comparator after");
//			 int index = Arrays.binarySearch(arr, new Wardrop(2, 4, 1),comp);
//			 System.out.println("index = "+ index);
//	 }
	 
	 @Test
	 void testHeightVolumeComparator() {
		 printArray(arr, "Test volume comparble befor");
			Comparator<Wardrop> comp = (w1,w2) -> {
				int res = w1.compareTo(w2);
				if(res!=0)return res;
				return Double.compare(w1.volume(), w2.volume());
				};
			Arrays.sort(arr, comp);
			 printArray(arr, "Test volume comparator after");
			 int index = Arrays.binarySearch(arr, new Wardrop(2, 4, 1),comp);
			 System.out.println("index = "+ index);
	 }
	 
	@Test
	void testIntengerDesc() {
		Integer[] actual = { 7, -5, 2, 0, -3 };
		Integer[] expected = { 7, 2, 0, -3, -5 };
		Arrays.sort(actual, (n1, n2) -> Integer.compare(n2, n1));
		assertArrayEquals(expected, actual);
		actual = new Integer[] { Integer.MIN_VALUE, Integer.MAX_VALUE, -1 };
		expected = new Integer[] { Integer.MAX_VALUE, -1, Integer.MIN_VALUE };
		Arrays.sort(actual, (n1, n2) -> Integer.compare(n2, n1));
		assertArrayEquals(expected, actual);

	}

}
