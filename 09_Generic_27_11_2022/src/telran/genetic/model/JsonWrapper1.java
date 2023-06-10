package telran.genetic.model;

public class JsonWrapper1 {
private Object value;

public JsonWrapper1(Object value) {
	super();
	this.value = value;
}

public Object getValue() {
	return value;
}

@Override
public String toString() {
	return "{value:"+value+"}";
}



}
