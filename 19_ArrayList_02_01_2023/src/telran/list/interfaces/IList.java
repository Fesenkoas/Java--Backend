package telran.list.interfaces;

public interface IList<E> extends Iterable<E> {
	default boolean add(E e) {
		return add(size(), e);
	}

	void clear();

	default boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	default boolean isEmpty() {
		return size() == 0;
	}

	default boolean remove(Object o) {
		int index = indexOf(0);
		if (index < 0)
			return false;
		remove(index);
		return true;
	}

	int size();

	// List
	boolean add(int index, E e);

	E get(int index);

	int indexOf(Object o);

	int lastIndexOf(Object o);

	E remove(int index);

	E set(int index, E e);

}
