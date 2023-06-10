package telran.set.interfese;

public interface ISet<E> extends Iterable<E> {
	boolean add(E elem);

	boolean contains(E elem);

	boolean remove(E elem);

	int size();
}
