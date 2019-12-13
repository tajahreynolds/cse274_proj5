
public interface NoDuplicatesPriorityQueueInterface<T extends Comparable<? super T>> extends PriorityQueueInterface<T> {

	/**
	 * Detects whether or not this priority queue contains an entry.
	 * @param anEntry the element to be checked for.
	 * @return True if this priority queue contains the specified element, and false otherwise.
	 */
	public boolean contains(T anEntry);
}
