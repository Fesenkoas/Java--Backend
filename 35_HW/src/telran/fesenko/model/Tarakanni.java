package telran.fesenko.model;

import java.util.Random;

public class Tarakanni implements Runnable {
	private String name;
	private int max;
	static String isWinner;

	public Tarakanni(String name, int max) {
		this.name = name;
		this.max = max;
	}

	@Override
	public void run() {
		int circle = 1;
		Random rand = new Random();
		System.out.println(name + " start...");
		for (int i = 0; i < max; i++) {
			System.out.println(name + ", circle = " + circle++);
			try {
				Thread.sleep(rand.nextInt(4) + 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isWinner = name;
		funcName();
	}
	public String funcName() {
		System.out.println("Winner roads " + name);
		return isWinner;

	}

}
