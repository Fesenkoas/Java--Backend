package telran.map.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitsFreqAppl {
	private static final int N_NUMBER = 1_000_000;
	private static Random random = new Random();

	public static void main(String[] args) {
		// TODO Homework
		// Generate N_NUMBERS integer numbers
		// Calculate digits frequency

		Map<Integer, Integer> digit = new HashMap<>();

		for (int i = 0; i < N_NUMBER; i++) {
			int num = random.nextInt(Integer.MAX_VALUE);
			String strNum = Integer.toString(num);

			for (int j = 0; j < strNum.length(); j++) {
				int res = Character.getNumericValue(strNum.charAt(j));

				if (digit.putIfAbsent(res, 1) != null) {
					digit.put(res, digit.get(res) + 1);
				}
			}
		}
//		for (Map.Entry<Integer, Integer> entry : digit.entrySet()) {
//			System.out.println("Digit " + entry.getKey() + " => " + entry.getValue());
//		}
		digit.forEach((k,v)-> System.out.println("Digit " + k + " => " + v));
	}
}
