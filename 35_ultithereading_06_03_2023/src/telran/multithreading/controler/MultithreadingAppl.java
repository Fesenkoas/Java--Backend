package telran.multithreading.controler;

import telran.multithreading.tasks.MyTaskImplement;
import telran.multithreading.tasks.MytaskExtend;

public class MultithreadingAppl {

	private static final int MAX = 10;
	private static final int SIZE = 3;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread start....");
		MyTaskImplement task1 = new MyTaskImplement("Task1", MAX);
		Thread thread1 = new Thread(task1);
		MytaskExtend task2 = new MytaskExtend("TaskExtend", MAX);
		MyTaskImplement[] task = new MyTaskImplement[SIZE];
		for (int i = 0; i < task.length; i++) {
			task[i] = new MyTaskImplement("Name#"+ i, MAX);
		}
		Thread[] threadsArr = new Thread[task.length];
		for (int i = 0; i < threadsArr.length; i++) {
			threadsArr[i] = new Thread(task[i]);
			threadsArr[i].setPriority(1);
			
		}
		for (int i = 0; i < threadsArr.length; i++) {

			threadsArr[i].start();
		}
		
		
		thread1.start();
		task2.start();
		for (int i = 0; i < MAX; i++) {
			System.out.println("ThreadMain count" + i);
		}
		thread1.join();
		System.out.println("Main thread stop....");
	}

}
