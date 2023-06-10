package telran.truck.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import telran.truck.model.Elevator;

public class Track implements Runnable {
	static Lock locker = new ReentrantLock();
	int nRaces;
	int capacity;
	Elevator elevator;

	public Track(int nRaces, int capacity, Elevator elevator) {
		this.nRaces = nRaces;
		this.capacity = capacity;
		this.elevator = elevator;

	}

	@Override
	public void run() {
		for (int i = 0; i < nRaces; i++) {
			locker.lock();
			try {
				elevator.add(capacity);
			} finally {
				locker.unlock();
			}
		}

	}

}
