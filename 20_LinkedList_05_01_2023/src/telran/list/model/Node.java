package telran.list.model;

public class Node<E> {
	Node<E> next;
	E data;
	Node<E> prev;

	public Node(Node<E> prev, E data, Node<E> next) {

		this.next = next;
		this.data = data;
		this.prev = prev;
	}

}
