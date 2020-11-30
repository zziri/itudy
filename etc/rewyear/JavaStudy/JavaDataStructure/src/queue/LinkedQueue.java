package queue;

public class LinkedQueue<T> {
	class QueueNode{
		T data;
		QueueNode next;
		
		public QueueNode(T data)
		{
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return data + " ";
		}	
	}
	
	private QueueNode head;
	private QueueNode front;
	private QueueNode rear; // 삽입되어야 할 위치
	private int count;

	public LinkedQueue(){
		head = null;
		front = null;
		rear = null;
		count = 0;
	}

	public void enqueue(T data)
	{
		QueueNode newNode = new QueueNode(data);
		if(isEmpty())
		{
			head = front = rear = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
		count++;
	}

	public void dequeue()
	{
		 if(isEmpty())
		 {
			 System.out.println("Queue is Empty");
			 return;
		 }
		 else if(front.next == null)
		 {
			 head = null;
			 front = null;
			 rear = null;
		 }
		 else
		 {
			 head = front.next; 
			 front.next = null;
			 front = head;
		 }
		 count--;
	}
	
	public T front()
	{
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		}
		else
			return (T)front;
	}

	public boolean isEmpty()
	{
		return (front==null && rear==null)? true:false;
	}
	
	public int getSize() {
		return this.count;
	}
}
