package fesenko.array.model;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer x, Integer y) {
		if (x % 2 - y % 2 != 0)
			return x % 2 - y % 2;
		if (x % 2 == 0)
			return x - y;
		return -(x - y);
	}
}
