/**
 * An interface to be used with the ADT queue.
 * @author TaJah
 *
 */
public interface NoDuplicatesQueueInterface<T> extends QueueInterface<T> {
	/**
	 * A method to check if this queue contains an entry
	 * @param newEntry the entry to be checked for
	 * @return True if this queue contains an entry, False otherwise
	 */
	public boolean contains(T newEntry);
}
