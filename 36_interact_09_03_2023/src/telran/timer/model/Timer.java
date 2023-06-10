package telran.timer.model;

import java.time.LocalTime;

public class Timer implements Runnable {
	int clockPer = 1;

	public int getClockPer() {
		return clockPer;
	}

	public void setClockPer(int clockPer) {
		this.clockPer = clockPer;
	}

	@Override
	public void run() {
		while(true) {
			System.out.println(LocalTime.now());
			try {
				Thread.sleep(clockPer*1000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				System.out.println(Thread.currentThread().getName()+"Bye bye");
				System.out.println(Thread.currentThread().isInterrupted());
				break;
			}
		}

	}

}
