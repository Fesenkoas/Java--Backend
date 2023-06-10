package telran.multithreading.tasks;

import java.util.Iterator;

public class MyTaskImplement implements Runnable {
	private String name;
	private int max;

	public MyTaskImplement(String name, int max) {
		this.name = name;
		this.max = max;
	}

	@Override
	public void run() {
		System.out.println(name + "task start....");
		for (int i = 0; i < max; i++) {
			System.out.println("task" + name + "count" + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + "task stop....");
	}

}
