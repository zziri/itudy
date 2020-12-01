package queue;

public class LinkedQueueTest {

	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		
		queue.enqueue(10);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(1);
		
		System.out.println(queue.front());
		queue.dequeue();
		System.out.println(queue.front());
		queue.dequeue();
		System.out.println(queue.front());
		queue.dequeue();
		System.out.println(queue.front());
		queue.dequeue();
		
		queue.enqueue(123);
		queue.enqueue(1);
		System.out.println(queue.front());
	}

}
