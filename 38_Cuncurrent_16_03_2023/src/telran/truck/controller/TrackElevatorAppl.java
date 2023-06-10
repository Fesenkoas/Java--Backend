package telran.truck.controller;

import telran.truck.model.Elevator;
import telran.truck.task.Track;

public class TrackElevatorAppl {

	private static final int N_TRUCK = 1000;
	private static final int N_RACES = 10;
	private static final int CAPACITY = 20;

	public static void main(String[] args) throws InterruptedException {
		Elevator lenin = new Elevator("Lenin");
		Track[] track = new Track[N_TRUCK];

		for (int i = 0; i < track.length; i++) {
			track[i] = new Track(N_RACES, CAPACITY, lenin);
		}
		Thread[] thread = new Thread[N_TRUCK];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(track[i]);
			thread[i].start();
		}
		for (int i = 0; i < thread.length; i++) {
			thread[i].join();
		}
		System.out.println("Elevator "+ lenin.getName()+ " has "+ lenin.getCurrentVolume()+ " tonn");
	}

}
