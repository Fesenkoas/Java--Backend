package telran.timer.model;

import java.time.Instant;
import java.time.LocalTime;

public class TimerMySleep implements Runnable {

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
				mySleep(clockPer*1000);
			} catch (InterruptedException e) {
				
				//e.printStackTrace();
				System.out.println(Thread.currentThread().getName()+"(aka Timer My Sleep)Bye bye");
				System.out.println(Thread.currentThread().isInterrupted());
				break;
			}
		}

	}

	private void mySleep(long per)throws InterruptedException {
		Instant time = Instant.now();
		Instant finish = time.plusMillis(per);
		while(time.isBefore(finish)) {
//			if(Thread.currentThread().isInterrupted()) {
//				throw new InterruptedException("Hello MySleep");
//			}
			if(Thread.interrupted()) {
				throw new InterruptedException("Hello MySleep");
			}
			time = Instant.now();
		}
			
		
	}

}
