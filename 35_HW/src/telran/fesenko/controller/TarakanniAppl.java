package telran.fesenko.controller;

import telran.fesenko.model.Tarakanni;

public class TarakanniAppl {

	private static final int SIZE = 3;
	private static final int MAX = 10;

	public static void main(String[] args) throws InterruptedException {
//		int numTarakans, distance;
//		numTarakans = Integer.parseInt(System.console().readLine("Enter the number of tarakans: "));
//		distance = Integer.parseInt(System.console().readLine("Enter the distance of the race: "));
		Thread[] threads = new Thread[SIZE];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Tarakanni("Tarakan #" + i, MAX));
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println("End");
	}

}
