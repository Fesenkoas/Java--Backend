package telran.genetic.model;

public class JsonWraooer2<T> {
	T value;

	public JsonWraooer2(T value) {
		super();
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "{value:" + value + "}";
	}

}
