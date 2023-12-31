package telran.mediation;

/**
 * This interface represents Blocking Queue for usage
 * as communication buffer between Producers and Consumers
 */
public interface IBlkQueue<T> {
	void push(T object);
	T pop();
}
