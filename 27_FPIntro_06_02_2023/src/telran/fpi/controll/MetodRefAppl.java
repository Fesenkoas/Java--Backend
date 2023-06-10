package telran.fpi.controll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetodRefAppl {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5);
		numbers.sort(Integer::compare);
		numbers.forEach(System.out::println);
		
	}
}
