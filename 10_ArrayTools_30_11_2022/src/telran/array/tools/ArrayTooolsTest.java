package telran.array.tools;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.solder.model.Solder;

class ArrayTooolsTest {
	Integer[] arrNum;
	String[] arrStr;
	Solder[] solders;

	@BeforeEach
	void setUp() throws Exception {
		arrNum = new Integer[] { 1, 2, 5, 4, 3, 6, 9, 8, 7 };
		arrStr = new String[] { "one", "two", "three", "four" };
		solders = new Solder[] { new Solder("dfsd", 182, 82.3, 91), new Solder("qqqqq", 175, 77.3, 96),
				new Solder("wwww", 162, 55.3, 96), new Solder("aaaa", 159, 59.0, 75), new Solder("bbbb", 175, 85.3, 91),
				new Solder("cccc", 162, 55.1, 91), };
	}

	@Test
	void test() {
		System.out.println("===Test PrintArray===");
		ArrayTools.printArray(arrNum);
		ArrayTools.printArray(arrStr);
	}

	@Test
	void testFindFirstByPredicate() {
		System.out.println("===Test findFirstByPredicate===");
		assertEquals(2, ArrayTools.findFirstByPredicate(arrNum, x -> x % 2 == 0));
		assertEquals("four", ArrayTools.findFirstByPredicate(arrStr, x -> x.length() == 4));
	}

	@Test
	void testBubbleSort() {
		System.out.println("===Test BubbleSort===");
		ArrayTools.bubbleSortNum(arrNum);
		ArrayTools.printArray(arrNum);
		ArrayTools.bubbleSortNum(arrStr);
		ArrayTools.printArray(arrStr);
		ArrayTools.bubbleSortNum(solders);
		ArrayTools.printArray(solders);
	}

	@Test
	void testBubbleSortComparator() {
		System.out.println("===Test BubbleSort Comparator===");
		ArrayTools.bubbleSortNum(solders, (s1, s2) -> s1.getProfile() - s2.getProfile());
		Comparator<Solder> comp1 = (s1, s2) -> {
			if (s1.getWeight() > s2.getWeight())
				return 1;
			if (s1.getWeight() < s2.getWeight())
				return -1;

			return 0;
		};
		// ArrayTools.bubbleSortNum(solders, comp1);
		ArrayTools.bubbleSortNum(solders, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
		ArrayTools.printArray(solders);
		Comparator<String> comp2 = (s1, s2) -> s1.length() - s2.length();
		ArrayTools.bubbleSortNum(arrStr, comp2);
		ArrayTools.printArray(arrStr);
	}

	@Test
	void testArraysSort() {
		System.out.println("===Test BubbleSort Arrays.sort===");
		Arrays.sort(arrNum);
		ArrayTools.printArray(arrNum);
		Arrays.sort(arrStr);
		ArrayTools.printArray(arrStr);
		Arrays.sort(solders);
		ArrayTools.printArray(solders);
	}
	
	@Test
	void testArraysSortComparator() {
		System.out.println("===Test BubbleSort Comparator===");
		//ArrayTools.bubbleSortNum(solders, (s1, s2) -> s1.getProfile() - s2.getProfile());
		Comparator<Solder> comp1 = (s1, s2) -> {
			if (s1.getWeight() > s2.getWeight())
				return 1;
			if (s1.getWeight() < s2.getWeight())
				return -1;

			return 0;
		};
		// ArrayTools.bubbleSortNum(solders, comp1);
		Arrays.sort(solders, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
		ArrayTools.printArray(solders);
		Comparator<String> comp2 = (s1, s2) -> s1.length() - s2.length();
		Arrays.sort(arrStr, comp2);
		ArrayTools.printArray(arrStr);
	}
	
	@Test
	void testArraysSortCompeProfile() {
		System.out.println("===Test BubbleSort Comparator profile===");
		Comparator<Solder> comp1 = (s1, s2) -> {
			int res = s1.getProfile() - s2.getProfile();
			if(res!=0)return res;
			return Integer.compare(s1.getHeight(), s2.getHeight());
		};
		Arrays.sort(solders,comp1);
		ArrayTools.printArray(solders);
		
	} 
	
}
