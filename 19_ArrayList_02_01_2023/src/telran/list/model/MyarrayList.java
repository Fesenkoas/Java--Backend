package telran.list.model;

import java.util.Arrays;
import java.util.Iterator;

import telran.list.interfaces.IList;

public class MyarrayList<E> implements IList<E> {
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private Object[] elements;
	private int size;

	public MyarrayList() {
//		elements = new Object[10];
		this(10);
	}

	public MyarrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal capacity " + initialCapacity);
		}
		if (initialCapacity > MAX_ARRAY_SIZE) {
			initialCapacity = MAX_ARRAY_SIZE;
		}
		elements = new Object[initialCapacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < size;
			}

			@SuppressWarnings("unchecked")
			@Override
			public E next() {
				return (E) elements[i++];
			}
		};
	}

	@Override
	// O(n)
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
//		elements = new Object[elements.length];

	}

	@Override
	// O(1)
	public int size() {
		return size;
	}

	@Override
	// O(n)
	public boolean add(int index, E element) {
		ensureCapacity();
		if (index == size) {
			elements[index] = element;
		} else {
			checkIndex(index);
			System.arraycopy(elements, index, elements, index + 1, size - index);
			elements[index] = element;
		}
		size++;
		return true;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index + " out of bounds");
		}

	}

	private void ensureCapacity() {
		if (size == MAX_ARRAY_SIZE) {
			throw new OutOfMemoryError();
		}
		if (size == elements.length) {
			int newCapacity = elements.length + elements.length / 2 + 1;
			if (newCapacity < 0 || newCapacity > MAX_ARRAY_SIZE) {
				newCapacity = MAX_ARRAY_SIZE;
			}
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	// O(1)
	public E get(int index) {
		checkIndex(index);
		return (E) elements[index];
	}

	@Override
	// O(n)
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == o) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	@Override
	// O(n)
	public int lastIndexOf(Object o) {
		if (o != null) {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o == elements[i]) {
					return i;
				}
			}
		}
		return -1;
	}

	@Override
	// O(n)
	public E remove(int index) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		E victim = (E) elements[index];
		System.arraycopy(elements, index + 1, elements, index, --size - index);
		return victim;
	}

	@Override
	// O(1)
	public E set(int index, E element) {
		checkIndex(index);
		@SuppressWarnings("unchecked")
		E victim = (E) elements[index];
		elements[index] = element;
		return victim;
	}

}
