package queue;

public class Queue<T> {      
	private int front;
	private int rear; // 삽입되어야 할 위치
	private Object[] queueArr;
	private int size;

	public Queue(int size){
		front=0;
		rear=0;
		this.size = size;
		queueArr = new Object[this.size];
	}

	public void enqueue(T data)
	{
		if(isFull())
			System.out.println("Queue is Full");
		else
		{
			queueArr[rear] = data;
			rear = (rear+1) % size;
		}

	}

	public void dequeue()
	{
		if(isEmpty())
			System.out.println("Queue is Empty");
		else
			front = (front+1) % size;   
	}
	
	public T front()
	{
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		}
		else
			return (T)queueArr[front];
	}

	public boolean isFull()
	{
		return (front == (rear+1)%size)? true:false;
	}

	public boolean isEmpty()
	{
		return (front == rear)? true:false;
	}
}
