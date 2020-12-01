package stack;

public class LinkedStack<T> {
	class StackNode{
		private T data;
		private StackNode next;
		
		public StackNode(T data)
		{
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return data + " ";
		}		
	}
	
	private StackNode top;
	private int count;

	public LinkedStack()
	{
		this.top = null;
		this.count = 0;
	}

	public void push(T data)
	{
		StackNode newStackNode = new StackNode(data);
		if(isEmpty()) // stack�� ����ִ°�� ���� �����ذ� head, top�� �ٷ� ����ų�� �ְ� �Ҵ�.
		{
			top = newStackNode;
		}
		else
		{
			newStackNode.next = top;
			top = newStackNode;
		}
		System.out.println("Data Pushed");
		count++;
	}

	public T Pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return null;
		}
		else
		{
			System.out.println("Data Poped");
			
			StackNode tmp = top;
			top = top.next;
			
			count--;
			return (T)tmp;
		}
	}

	public T Peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty");
			return null;
		}
		else
		{
			System.out.println("Data Peeked");            
			return (T)top;
		}
	}

	public boolean isEmpty()
	{
		return (top == null) ? true:false;
	}

	
	
}
