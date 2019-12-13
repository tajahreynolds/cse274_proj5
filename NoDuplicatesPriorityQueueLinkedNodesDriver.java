
public class NoDuplicatesPriorityQueueLinkedNodesDriver {

	public static void main(String[] args) {
		NoDuplicatesPriorityQueueLinkedNodes<Integer> queue = new NoDuplicatesPriorityQueueLinkedNodes<Integer>();
		// isEmpty should return true
		System.out.println("Empty:" + queue.isEmpty());
		// Testing adding
		queue.add(8);
		queue.add(36);
		queue.add(1);
		queue.add(24);
		queue.add(-5);
		queue.add(18);
		queue.add(1); // Duplicate will not get added
		
		// Peek should return 36 (highest priority)
		System.out.println("Peek: " + queue.peek());
		
		// isEmpty should return false;
		System.out.println("Empty: " + queue.isEmpty());
		
		// Get size of queue (6)
		System.out.println("Size: " + queue.getSize());
		
		// Remove should return values in descending order
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
		// Clearing
		queue.add(8);
		queue.add(36);
		queue.add(1);
		queue.add(24);
		queue.add(-5);
		queue.add(18);
		
		queue.clear();
		
		System.out.println("Empty: " + queue.isEmpty());
		System.out.println("Size: " + queue.getSize());
		 
		// Should throw exception
		queue.remove();

	}

}
