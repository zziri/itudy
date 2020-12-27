package queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(10);
		
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
