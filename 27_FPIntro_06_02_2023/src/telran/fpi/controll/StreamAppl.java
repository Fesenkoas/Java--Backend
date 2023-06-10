package telran.fpi.controll;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAppl {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 9, 2, 8, 3, 7, 4, 6, 5);
		numbers.stream()
		.filter(x -> x > 3)
		.sorted((x, y) -> Integer.compare(y, x))
		.forEach(System.out::println);

		Stream<Integer> stream = numbers.stream()
				.filter(x -> x > 3)
				.sorted((x, y) -> Integer.compare(y, x))
				.peek(x -> System.out.println("x-" + x));

		int num = stream.findFirst().orElse(Integer.MIN_VALUE);
		System.out.println("Find first = " + num);

		Integer res = numbers.stream()
				.filter(x -> x % 2 != 0)
				.reduce(0, (accum, n) -> accum + n);
		System.out.println("result = " + res);
		String str = numbers.stream()
				.filter(x -> x % 2 == 0)
				.sorted((x, y) -> Integer.compare(y, x))
				.map(x->x+"-").reduce("Concat = ",(a,b)-> a+b);
		System.out.println(str);

	}
}
