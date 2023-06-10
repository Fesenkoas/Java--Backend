package telran.truck.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Elevator {
	String name;
	//AtomicInteger currentVolume = new AtomicInteger(0);
	int currentVolume;

	public Elevator(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentVolume() {
		//return currentVolume.get();
		return currentVolume;
	}

	public void add(int portion) {
		currentVolume += portion;
//		currentVolume.getAndAdd(portion);
		//currentVolume.addAndGet(portion);
	}
}
