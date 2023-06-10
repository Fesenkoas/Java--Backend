package telran.timer.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import telran.timer.model.Timer;
import telran.timer.model.TimerMySleep;

public class Interract {

	public static void main(String[] args) throws IOException {
		//Timer timer = new Timer();
		TimerMySleep timer = new TimerMySleep();
		Thread thread = new Thread(timer);
//		thread.setDaemon(true);
		thread.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 while(true) {
			 System.out.println("Enter time interval, or Q for exit");
			 String str = br.readLine();
			 if("q".equalsIgnoreCase(str)) {
				 //thread.stop();
				 thread.interrupt();
				 break;
			 }else {
				 timer.setClockPer(Integer.parseInt(str));
				 
			 }
		 }
System.out.println(Thread.currentThread().getName()+"Main Stop");
		 
	}

}
