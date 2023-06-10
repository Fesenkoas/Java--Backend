package telran.fibonacci.controller;

import java.util.Iterator;

import telran.fibonacci.model.Fibonacci;

public class FibonacciAppl {

	public static void main(String[] args) {
		int res = 0;
		Fibonacci fibonacci = new Fibonacci(8);
		Iterator<Integer> iterator = fibonacci.iterator();
		while(iterator.hasNext()) {
			 int sum =iterator.next();
			 res+=sum;
			System.out.print(sum+" ");
		}
		System.out.println();
		System.out.println(res);
		//TODO print all numbers, and reduce sum
		//1,1,2,3,5,8,13,21
		//sum = 54

	}

}
