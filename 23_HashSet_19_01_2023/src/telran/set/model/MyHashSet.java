package telran.set.model;

import java.util.Iterator;
import java.util.LinkedList;

import telran.set.interfese.ISet;

public class MyHashSet<E> implements ISet<E> {
	private LinkedList<E>[] hashSet;
	private int size;
	private int capacity;
	private double loadFactor;

	public MyHashSet(int capacity, double loadFactor) {

		this.capacity = capacity;
		this.loadFactor = loadFactor;
		hashSet = new LinkedList[capacity];
	}

	public MyHashSet(int capacity) {
		this(capacity, 0.75);
	}

	public MyHashSet() {
		this(16, 0.75);
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<>() {
			int totalCount;
			int i;
			int j;

			@Override
			public boolean hasNext() {
				return totalCount < size;
			}

			@Override
			public E next() {
				while (hashSet[i] == null || hashSet[i].isEmpty()) {
					i++;
				}
				E res = hashSet[i].get(j);
				totalCount++;
				if (j < hashSet[i].size() - 1)
					j++;
				else {
					i++;
					j=0;
					}
				return res;
			}

		};
	}

	@Override 
	//O 1 константная сложность
	public boolean add(E elem) {
		if (size >= loadFactor * capacity) {
			rebuildArray();
		}
		int index = getIndex(elem);

		if (hashSet[index] == null)
			hashSet[index] = new LinkedList<>();

		if (hashSet[index].contains(elem))
			return false;

		hashSet[index].add(elem);
		size++;
		return true;
	}

	private int getIndex(E elem) {
		int hashCode = elem.hashCode();
		hashCode = hashCode < 0 ? -hashCode : hashCode;
		return hashCode % capacity;
	}

	private void rebuildArray() {
		capacity = capacity * 2;
		LinkedList<E>[] newHashSet = new LinkedList[capacity];
		for (int i = 0; i < hashSet.length; i++) {
			if (hashSet[i] == null) {
				for (E e : hashSet[i]) {
					int index = getIndex(e);
					if (newHashSet[index] == null)
						newHashSet[index] = new LinkedList<>();
					newHashSet[index].add(e);
				}
			}

		}
		hashSet = newHashSet;

	}

	@Override
	//O(1)
	public boolean contains(E elem) {
		int index = getIndex(elem);
		if (hashSet[index] == null)
			return false;

		return hashSet[index].contains(elem);
	}

	@Override
	//O(1)
	public boolean remove(E elem) {
		int index = getIndex(elem);
		if (hashSet[index] == null || !hashSet[index].remove(elem))
			return false;

		size--;
		return true;
	}

	@Override
	//O(1)
	public int size() {

		return size;
	}

}
