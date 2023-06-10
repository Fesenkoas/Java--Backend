package telran.integral.task;

import java.util.Iterator;
import java.util.function.Function;

public class SumRectangles implements Runnable {
	double a;
	double b;
	Function<Double, Double> func;
	double result;
	int nThreads;
	int nParts;
	int start;

	public double getResult() {
		return result;
	}

	public SumRectangles(double a, double b, Function<Double, Double> func, int nThreads, int nParts, int start) {
		this.a = a;
		this.b = b;
		this.func = func;
		this.nThreads = nThreads;
		this.nParts = nParts;
		this.start = start;
	}

	@Override
	public void run() {
		double delta = (b - a) / nParts;
		for (int i = start; i < nParts; i += nThreads) {
			double l = a + i * delta;
			double r = l + delta;
			double x = (l + r) / 2;
			result += func.apply(x) * delta;
		}

	}

}
