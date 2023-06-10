package telran.truck.task;

import telran.truck.model.Elevator;

public class Track implements Runnable {
	int nRaces;
	int capacity;
	Elevator elevator;
	Elevator elevator1;
	static Object mutex = new Object();
	static Object mutex1 = new Object();

	public Track(int nRaces, int capacity, Elevator elevator, Elevator elevator1) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevator = elevator;
		this.elevator1 = elevator1;
	}

	@Override
	public void run() {
		for (int i = 0; i < nRaces; i++) {
			synchronized (mutex) {
				elevator.add(capacity/2);
			}
			synchronized (mutex1) {
				elevator1.add(capacity/2);
			}
			
		}
		

	}

}
