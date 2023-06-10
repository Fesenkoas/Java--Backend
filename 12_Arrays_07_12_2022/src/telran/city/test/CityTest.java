package telran.city.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.city.model.City;

class CityTest {

	City[] usa;

	@BeforeEach
	void setUp() throws Exception {
		usa = new City[6];
		usa[0] = new City("Denver", 600_000);
		usa[1] = new City("Boston", 670_000);
		usa[2] = new City("Chicago", 2_700_000);
		usa[3] = new City("Atlanta", 470_000);
		usa[4] = new City("New_York", 8_500_000);
		usa[5] = new City("Dallas", 1_300_000);
	}

//	@Test
//	void test() {
//		printArray(usa, "Original Arr");
//		Arrays.sort(usa);
//		printArray(usa, "Natural order");
//		City pattern = new City("Chicago", 2_700_000);
//		int index = Arrays.binarySearch(usa, pattern);
//		System.out.println(index);
//	}

//	@Test
//	void testNameComporator() {
//		Comparator<City> comp = (c1,c2) -> c1.getName().compareTo(c2.getName());
//		Arrays.sort(usa, comp);
//		printArray(usa, "sort by Name");
//		City pattern = new City("Chicago", 0);
//		int index = Arrays.binarySearch(usa, pattern, comp);
//		System.out.println("Index = "+ index);
//		
//	}

//	@Test 
//	void testArrayCopy() {
////		City[] copyArr = copyArr(usa);
//		City[] copyArr = Arrays.copyOf(usa, usa.length*2);
//		printArray(copyArr, "CopyArray before sort");
//		Arrays.sort(copyArr,0,usa.length);
//		printArray(copyArr, "Sort CopyArray");
//		City pattern = new City(null, 2_700_000);
//		int index = Arrays.binarySearch(copyArr,1,usa.length-1, pattern);
//		System.out.println("Index = "+ index);
//	}

//	@Test
//	void testCopyofRange() {
//		City[] copyArr = Arrays.copyOfRange(usa, 1, usa.length - 1);
//		printArray(copyArr, "Copy of range");
//	}
	
	@Test
	void testSystemArrCopy() {
		City[] copyArr = new City[usa.length*2];
		System.arraycopy(usa, 1, copyArr, 3, 4);
		printArray(copyArr, "System copy");
	}

	private City[] copyArr(City[] arr) {
		City[] res = new City[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	private void printArray(City[] arr, String title) {
		System.out.println("===" + title + "===");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
