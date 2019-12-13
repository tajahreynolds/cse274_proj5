
public final class NoDuplicatesPriorityQueueLinkedNodes<T extends Comparable<? super T>> implements NoDuplicatesPriorityQueueInterface<T> {

	private Node head;
	
	public NoDuplicatesPriorityQueueLinkedNodes() {
		head = null;
	}
	
	@Override
	public void add(T newEntry) {
		if (isEmpty()) {
			head = new Node(newEntry);
		} else if (contains(newEntry)) {
			return; // No duplicates
		} else {
			Node curr = head;
			Node newNode = new Node(newEntry);
			
			while (curr.next != null) {	// Current node is not last node
				if (curr.data.compareTo(newNode.data) < 0) {	// Current node has lower priority than newNode
					if (curr.next.data.compareTo(newNode.data) < 0) { // Next node has lower priority than newNode
						curr = curr.next;
					} else {	// newNode is between current node and next node
						newNode.next = curr.next;
						curr.next = newNode;
						return;
					} // end if
				} else {
					break;
				} // end if
			} // end while
			
			// Current node is last node
			if (curr.equals(head)) {	// Head is the last node
				if (curr.data.compareTo(newNode.data) > 0) {	// New node comes before head
					newNode.next = curr;
					head = newNode;
				} else {	// New node comes after head
					curr.next = newNode;
				}
			} else {
				curr.next = newNode;
			} // end if
		} // end if
	}

	
	@Override
	public T remove() {
		if (isEmpty())
			throw new EmptyQueueException();
		Node curr = head;
		if (curr.next == null) {
			T ret = curr.data;
			head = null;
			return ret;
		}
		while (curr.next.next != null) {
			curr = curr.next;
		}
		T ret = curr.next.data;
		curr.next = null;
		return ret;
	}

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyQueueException();
		
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		return curr.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int getSize() {
		if (isEmpty())
			return 0;
		
		int count = 1;
		Node curr = head;
		while (curr.next != null) {
			count++;
			curr = curr.next;
		}
		
		return count;
	}

	@Override
	public void clear() {
		head = null;
	}

	@Override
	public boolean contains(T anEntry) {
		Node curr = head;
		while (curr.next != null) {
			if (curr.data.equals(anEntry))
				return true;
			else
				curr = curr.next;
		}
		if (curr.data.equals(anEntry))
			return true;
		
		return false;
	}

	private class Node {
		private Node next;
		private T data;
		
		public Node(T data) {
			this.data = data;
		}
		
	}
	
}
