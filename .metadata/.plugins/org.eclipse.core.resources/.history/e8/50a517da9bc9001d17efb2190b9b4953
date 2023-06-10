package telran.integral.controller;

import java.util.Arrays;
import java.util.function.Function;

import telran.integral.task.SumRectangles;

public class IntegralThreadAppl {

	private static final int N_TASKS = 10;
	private static final double A = 1;
	private static final double B = 3;
	private static final Function<Double, Double> FUNC = x -> x * x;
	private static final int N_PARTS = 1_000_000;

	public static void main(String[] args) throws InterruptedException {
		SumRectangles[] task = new SumRectangles[N_TASKS];
		for (int i = 0; i < task.length; i++) {
			task[i] = new SumRectangles(A, B, FUNC, N_TASKS, N_PARTS, i);
		}
		Thread[] thread = new Thread[N_TASKS];
		long t1 = System.currentTimeMillis();
		for (int j = 0; j < thread.length; j++) {
			thread[j] = new Thread(task[j]);
			thread[j].start();
		}
		for (int i = 0;  i< thread.length; i++) {
			thread[i].join();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Time "+ (t2-t1));
		double res = Arrays.stream(task).mapToDouble(SumRectangles::getResult).sum();
		System.out.println(res);
	}

}
