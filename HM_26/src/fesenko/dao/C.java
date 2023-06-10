package fesenko.dao;

import java.util.ArrayList;
import java.util.Collections;

public class C implements  EntityCollection {
	ArrayList<Entity> entryC = new ArrayList<>();

	@Override
	//O(1)
	public void add(Entity entity) {

		entryC.add(entity);

	}

	@Override
	//O(Log n)
	public Entity removeMaxValue() {
		if (!entryC.isEmpty()) {
			Collections.sort(entryC, (s1 , s2) -> s2.getValue() - s1.getValue());
		    return entryC.remove(entryC.size() - 1);
		}
		return null;
	}
}
