package telran.streamprimitive.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PrimitiveStreamAppl {

	private static final int N_NUMBER = 6;
	private static final int MIN = 1;
	private static final int MAX = 50;

	public static void main(String[] args) {
		//List<Integer> num = getRandomNum(N_NUMBER, MIN, MAX);
		//num.forEach(System.out::println);
//	IntSummaryStatistics sum = num.stream()
//			.mapToInt(Integer::intValue)
//			//.min()
//			//.getAsInt();
//			.summaryStatistics();
//	System.out.println(sum.getMax()+"_"+ sum.getMin());
//		int[] arr = {10,20,30,40,50};
//		new Random()
//		.ints(0, arr.length)
//		.distinct()
//		.limit(arr.length)
//		.forEach(i -> System.out.println(arr[i]));
		
		getRandomNum(100, 0, 1000).stream()
		.collect(Collectors.groupingBy(n -> n.toString().length()))
		.forEach((k,v)-> System.out.println(k + "->" + v));

	}

	private static List<Integer> getRandomNum(int quantity, int min2, int max2) {
		// TODO Auto-generated method stub
//		return new Random()
//				.ints(min2, max2)
//				.distinct()
//				.limit(6)
//				.boxed()
//				.collect(Collectors.toList());
		return new Random()
				.ints(quantity,min2, max2)
				.boxed()
				.collect(Collectors.toList());
	}

}
