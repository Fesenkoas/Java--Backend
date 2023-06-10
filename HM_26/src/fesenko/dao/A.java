package fesenko.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class A implements EntityCollection {
	Set<Entity> entryA = new HashSet<>();

	@Override
	//O(1)
	public void add(Entity entity) {

		entryA.add(entity);

	}

	@Override
	//O(n)
	public Entity removeMaxValue() {
		Entity max = null;
		if (!entryA.isEmpty()) {

			for (Entity e : entryA) {
				if (e.getValue() > max.getValue()) {
					max = e;
				}
			}
			entryA.remove(max);
			return max;
		}
		return null;
	}

}
