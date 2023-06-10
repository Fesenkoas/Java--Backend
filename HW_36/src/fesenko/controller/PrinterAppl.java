package fesenko.controller;

import fesenko.model.Printer;

public class PrinterAppl {

	private static final int SIZE = 4;
	private static final int COL = 100;
	private static final int POR = 10;

	public static void main(String[] args) throws InterruptedException {

		Thread[] thread = new Thread[SIZE];

		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new Printer(POR, i + 1));
			thread[i].start();

		}
		int j = 0;
		while (j < COL/POR) {
			

			for (int i = 0; i < thread.length; i++) {
				thread[i].interrupt();
				thread[i].join();
			}

			for (int i = 0; i < thread.length; i++) {
				thread[i] = new Thread(new Printer(POR, i + 1));
				thread[i].start();
			}

			j++;
			System.out.println("---------------------------");
		}
	}

}
