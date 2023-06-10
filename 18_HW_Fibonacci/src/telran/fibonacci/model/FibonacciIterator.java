package telran.fibonacci.model;

import java.util.Iterator;

//1,1,2,3,5,8,13,21
public class FibonacciIterator implements Iterator<Integer> {
	private int sum;
	private int sum2;
	private int size;
	private int currPos;

	public FibonacciIterator(int size) {
		this.size = size;
		sum2 = 1;
	}

	@Override
	public boolean hasNext() {
		return currPos < size;
	}

	@Override
	public Integer next() {
		int res = sum + sum2;
		sum = sum2;
		sum2 = res;
		currPos++;
		return sum;
	}

}
