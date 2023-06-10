package fesenko.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pomegranate implements Iterable<Seed> {
	public List<Seed> seeds;

	public Pomegranate() {
		this.seeds = new ArrayList<>();
	}

	public void addSeed(Seed seed) {
		seeds.add(seed);
	}

	@Override
	public Iterator<Seed> iterator() {
		// TODO Auto-generated method stub
		return seeds.iterator();
	}

}
