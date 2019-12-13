
public class NoDuplicatesQueueArray<T> implements NoDuplicatesQueueInterface<T> {

	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	
	public NoDuplicatesQueueArray() {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	public NoDuplicatesQueueArray(int initialCapacity) {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
		initialized = true;
	} // end constructor


	@Override
	public void enqueue(T newEntry) {
		checkInitialization();
		ensureCapacity();
		
		if (contains(newEntry))
			return;
		
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	} // end enqueue

	private void ensureCapacity() {
		if (frontIndex == ((backIndex + 2) % queue.length)) // If array is full, 
		{													// double size of array
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			
			// The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++)
			{
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			} // end for
			frontIndex = 0;
			backIndex = oldSize - 2;
		} // end if
	} // end ensureCapacity

	private void checkInitialization() {
		if (!initialized) 
			throw new EmptyQueueException();
		
	}

	@Override
	public T dequeue() {
		checkInitialization();
		if(isEmpty())
			throw new EmptyQueueException();
		else
		{
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		} // end if
	} // end dequeue

	@Override
	public T getFront() {
		checkInitialization();
		
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return queue[frontIndex];
	} // end getFront

	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	}

	@Override
	public void clear() {
		frontIndex = 0;
		backIndex =  queue.length - 1;
		
	}

	@Override
	public boolean contains(T newEntry) {
		if (isEmpty())
			return false;
		
		if (frontIndex < backIndex) {
			for (int i = frontIndex; i < backIndex; i++) {
				if (queue[i] == null)
					continue;
				if (queue[i].equals(newEntry))
					return true;
			}
		} else {
			for (int i = 0; i <= backIndex; i++) {
				if (queue[i] == null)
					continue;
				if (queue[i].equals(newEntry))
					return true;
			} // end for
			
			for (int i = frontIndex; i < queue.length; i++) {
				if (queue[i] == null)
					continue;
				if (queue[i].equals(newEntry))
					return true;
			}
		}
		
		return false;
	}

}
