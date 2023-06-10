package fesenko.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box implements Iterable<Pomegranate> {
	public String name;
	public List<Pomegranate> granates;

	public Box(String name) {
		this.name = name;
		this.granates = new ArrayList<>();
	}

	public void addPomegranate(Pomegranate pomegranate) {
		granates.add(pomegranate);
	}

	@Override
	public Iterator<Pomegranate> iterator() {
		// TODO Auto-generated method stub
		return granates.iterator();
	}

}
