package telran.volatiles.controller;

import telran.volatiles.task.InfinityLoop;

public class InfinityLoopAppl {

	public static void main(String[] args) throws InterruptedException {
		InfinityLoop task = new InfinityLoop();
		Thread thread = new Thread(task);
		thread.start();
		Thread.sleep(3000);
		task.setFlag(false);
		System.out.println("in main thread flag = "+ task.isFlag());

	}

}
