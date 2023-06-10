package fesenko.model;

public class Printer implements Runnable {
	private int size;
	private int digital;

	public Printer(int size, int digital) {
		this.size = size;
		this.digital = digital;
	}

	@Override
	public void run() {
		int i = 0;
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			while (i < size) {
				System.out.print(digital);
				i++;
			}
			System.out.println();
		}

		

	}

}
