package fesenko.dao;

import java.util.TreeSet;

public class B implements EntityCollection {

	 TreeSet<Entity> entities = new TreeSet<>();
	 

    @Override
    //O(log n)
    public void add(Entity entity) {
    	entities.add(entity);
    }

    @Override
    //O(log n)
    public Entity removeMaxValue() {
    	Entity e = entities.last();
      entities.remove(e);
      return e;
    }

}
