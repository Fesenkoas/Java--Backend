package telran.fibonacci.model;

import java.util.Iterator;
// 1,1,2,3,5,8,13,21
public class Fibonacci implements Iterable<Integer> {
	private int quantity;

	public Fibonacci(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new FibonacciIterator(quantity);
	}

}
