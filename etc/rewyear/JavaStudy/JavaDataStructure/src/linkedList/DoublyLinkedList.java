package linkedList;

class InvalidIndex extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidIndex(String str)
	{
		super(str);
	}
}

public class DoublyLinkedList<T> {
	class Node{   
		private T data;
		private Node prev;
		private Node next;

		public Node(T data)
		{
			this.prev = null;
			this.data = data;
			this.next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

	private Node head;
	private Node tail;
	private int count;

	public DoublyLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}

	public void addFirst(T data)
	{
		Node newNode = new Node(data);
		if(head == null) // 비어있는 linked list인 경우
		{
			head = tail = newNode;
			head.prev = null;
			head.next = null;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		count++;

	}

	// list 맨 마지막에 삽입하는 경우
	public void addLast(T data)
	{	 
		Node newNode = new Node(data);
		if(tail == null) // 비어있는 linked list인 경우
		{
			head = tail = newNode;
			tail.prev = null;
			tail.next = null;
		}	
		else
		{
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		count++;     
	}

	// 해당 index 위치에 삽입하는 경우
	public void add(int idx, T data)
	{
		try{
			valid(idx);
		}
		catch(InvalidIndex msg)
		{
			System.out.println(msg);
		}
		
		Node newNode = new Node(data);

		if(head == null) // 비어있는 linked list인 경우
		{
			head = tail = newNode;
			head.prev = null;
			head.next = null;
		}
		else if(idx == 0) // 맨 앞에 삽입하는 경우
		{     
			addFirst(newNode.getData());
		}
		else if(idx == count) // 맨 마지막에 삽입하는 경우
		{     
			addLast(newNode.getData());
		}
		else
		{
			Node pNode = head;
			for(int i=0; i<idx; i++) // 해당 index까지 이동
			{
				pNode = pNode.next;   
			}
			
			newNode.prev = pNode.prev;
			newNode.next = pNode;
			pNode.prev.next = newNode;			
			pNode.prev = newNode;

		}
		count++;
	}

	public void remove(int idx)
	{
		try
		{
			valid(idx);
		}
		catch(InvalidIndex msg)
		{
			System.out.println(msg);
		}


		// 맨 앞의 노드를 삭제하는 경우
		if(idx == 0)
		{   
			head = head.next;
			head.prev = null;
		}
		else if(idx == (count-1)) // 맨 뒤의 노드를 삭제하는 경우
		{     
			tail = tail.prev;
			tail.next = null;
		}
		else
		{
			Node pNode = head;
			for(int i=0; i<idx; i++) // 해당 index까지 이동
			{
				pNode = pNode.next;   
			}
			
			pNode.next.prev = pNode.prev;
			pNode.prev.next = pNode.next;
		}
		count--;

	}

	public void valid(int idx) throws InvalidIndex
	{
		if(idx > count)
		{
			throw new InvalidIndex("Invalid Index");
		}
	}

	public int getSize()
	{
		return count;
	}

	public boolean isEmpty()
	{
		return (count == 0)? true:false; 
	}

	@Override
	public String toString() {
		String str = "[";
		Node tmp = head;

		while(tmp.next != null) {
			str+= tmp.data + ",";
			tmp= tmp.next;
		}
		str+= tmp.data + "]";
		return str;
	}



}







