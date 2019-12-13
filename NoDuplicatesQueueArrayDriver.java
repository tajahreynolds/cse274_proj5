
public class NoDuplicatesQueueArrayDriver {

	public static void main(String[] args) {
		NoDuplicatesQueueArray<Integer> q = new NoDuplicatesQueueArray<Integer>(5);
		
		// Testing enqueue and dequeue
		System.out.println("Testing enqueue, adding duplicates, and dequeue");
		q.enqueue(1);
		q.enqueue(1);
		q.enqueue(1);

		System.out.println(q.dequeue());
		
		q.enqueue(2);
		
		System.out.println(q.dequeue());
		
		// Array Resizes
		System.out.println();
		System.out.println("Making sure array increases in size");
		for (int i = 0; i < 10; i++) {
			q.enqueue(10-i);
		}
		 
		// getFront
		System.out.println();
		System.out.println("Testing getFront and dequeue");
		for (int i = 0; i < 10; i++) {
			System.out.println(q.getFront());
			System.out.println(q.dequeue());
		}
		
		// clear method
		System.out.println();
		System.out.println("Testing clear method");
		for (int i = 0; i < 4; i++) {
			q.enqueue(4-i);
		}
		
		q.clear();
		
		System.out.println(q.isEmpty());
		
		// empty queue
		System.out.println();
		System.out.println("Next call should throw exception");
		System.out.println(q.getFront());
		System.out.println(q.dequeue());
	} // end main

//	OUTPUT:
//	Testing enqueue, adding duplicates, and dequeue
//	1
//	2
//
//	Making sure array increases in size
//
//	Testing getFront and dequeue
//	10
//	10
//	9
//	9
//	8
//	8
//	7
//	7
//	6
//	6
//	5
//	5
//	4
//	4
//	3
//	3
//	2
//	2
//	1
//	1
//
//	Testing clear method
//	true
//
//	Next call should throw exception
//	Exception in thread "main" EmptyQueueException
//		at NoDuplicatesQueueArray.getFront(NoDuplicatesQueueArray.java:83)
//		at NoDuplicatesQueueArrayDriver.main(NoDuplicatesQueueArrayDriver.java:48)

}
