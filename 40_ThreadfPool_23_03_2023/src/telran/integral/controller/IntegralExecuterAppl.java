package telran.integral.controller;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import telran.integral.task.SumRectangles;

public class IntegralExecuterAppl {
	private static final int N_TASKS = 10_000;
	private static final double A = 1;
	private static final double B = 3;
	private static final Function<Double, Double> FUNC = x -> x * x;
	private static final int N_PARTS = 1_000_000;

	public static void main(String[] args) throws InterruptedException {
		SumRectangles[] task = new SumRectangles[N_TASKS];
		for (int i = 0; i < task.length; i++) {
			task[i] = new SumRectangles(A, B, FUNC, N_TASKS, N_PARTS, i);
		}
		int poolSize = Runtime.getRuntime().availableProcessors();
		long t1 = System.currentTimeMillis();
		//ExecutorService exeService = Executors.newFixedThreadPool(poolSize);
		ExecutorService exeService = Executors.newWorkStealingPool();
		for (int i = 0;  i< task.length; i++) {
			exeService.execute(task[i]);
		}
		exeService.shutdown();//close thread
		exeService.awaitTermination(1, TimeUnit.MINUTES);
		long t2 = System.currentTimeMillis();
		System.out.println("Time "+ (t2-t1));
		double res = Arrays.stream(task).mapToDouble(SumRectangles::getResult).sum();
		System.out.println(res);
	}

}
