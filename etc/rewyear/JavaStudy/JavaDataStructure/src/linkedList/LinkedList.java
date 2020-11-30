package linkedList;

class InvalidIndex extends Exception {
	public InvalidIndex(String str)
	{
		super(str);
	}
}

public class LinkedList<T>{
	class Node{   
		private T data;
		private Node next;

		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
	    }
	}
	
	private Node head;
	private int count;

	public LinkedList()
	{
		head = null;
	    count = 0;
	}
	
	public void addFirst(T data)
	{	 
	   if(head == null) // ����ִ� linked list�� ���
	   {
		   head = new Node(data,null);
	   }
	   else
	   {
         Node tmp = head;
         head = new Node(data,head);         
        
	   }
	   count++;
	      
	}
	
	// list �� �������� �����ϴ� ���
	public void addLast(T data)
	{	 
	   if(head == null) // ����ִ� linked list�� ���
	   {
		   head = new Node(data,null);
	   }
	   else
	   {
         Node pNode = head;
         while(pNode.next != null)
         {
            pNode = pNode.next;
         
         }
         pNode.next = new Node(data,null);
	   }
	   count++;
	      
	}

   // �ش� index ��ġ�� �����ϴ� ���
   public void add(int idx, T data)
   {
	   try{
		   valid(idx);
	   }
	   catch(InvalidIndex msg)
	   {
		   System.out.println(msg);
	   }

	   if(head == null) // ����ִ� linked list�� ���
	   {
		   head = new Node(data,null);
	   }
	   else if(idx == 0) // �� �տ� �����ϴ� ���
	   {      
		   head = new Node(data,head);
	   }
	   else
	   {
		   Node prev = null;
		   Node pNode = head;
		   
		   for(int i=0; i<idx; i++) // �ش� index ��ġ ������ �̵�
		   {
			   prev = pNode;
			   pNode = pNode.next;   
		   }

		   if(pNode == null) // �� �ڿ� �����ϴ� ���
		   {
			   prev.next = new Node(data,null);
		   }
		   else // �ش� ��ġ�� �����ϴ� ��� ���� next ��带 tmp�� �����صΰ� ���� ��ġ�� ��尡 ���� ������ ��带 ����Ű�� �Ѵ��� ���ο� ���� tmp�� ����Ŵ
		   {
			   prev.next = new Node(data,pNode);
		   }
      
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

   		
   		// �� ���� ��带 �����ϴ� ���
   		if(idx == 0)
   		{   
   			head = head.next;
   		}
   		else
   		{
   			Node prev = null;
   			Node pNode = head;
   	   		Node next;
   	   		  			
   			next = head.next;
   			for(int i=0; i<idx; i++) // �ش� index ��ġ ������ �̵�
   			{
   				prev = pNode;
   				pNode = pNode.next;   
   			}
   			prev.next = pNode.next;
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

