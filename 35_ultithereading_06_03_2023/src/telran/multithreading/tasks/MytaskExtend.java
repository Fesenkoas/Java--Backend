package telran.multithreading.tasks;

public class MytaskExtend extends Thread {
	private String name;
	private int max;
	
	public MytaskExtend(String name, int max) {
		this.name = name;
		this.max = max;
	}

	@Override
	public void run() {
		System.out.println(name + "taskExtend start....");
		for (int i = 0; i < max; i++) {
			System.out.println("taskExtend" + name + "count" + i);
		}
		System.out.println(name + "taskExtend stop....");

	}

}
