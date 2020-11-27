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
	
	// list 맨 마지막에 삽입하는 경우
	public void add(T data)
	{	 
	   if(head == null) // 비어있는 linked list인 경우
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

	   Node prev;
	   Node pNode;
	   Node tmp;

	   // 맨 앞에 삽입하는 경우 
	   if(idx == 0)
	   {      
		   tmp = head;
		   head = new Node(data,tmp);
	   }
	   else
	   {
		   prev = null;
		   pNode = head;
		   for(int i=0; i<idx; i++) // 해당 index 위치 전까지 이동
		   {
			   prev = pNode;
			   pNode = pNode.next;   
		   }

		   if(pNode == null) // 맨 뒤에 삽입하는 경우
		   {
			   prev.next = new Node(data,null);
		   }
		   else // 해당 위치에 삽입하는 경우 기존 next 노드를 tmp에 저장해두고 현재 위치의 노드가 새로 삽입할 노드를 가리키게 한다음 새로운 노드는 tmp를 가리킴
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

   		Node pNode;
   		Node prev;
   		Node next;
   		// 맨 앞의 노드를 삭제하는 경우
   		if(idx == 0)
   		{   
   			head = head.next;
   		}
   		else
   		{
   			prev = null;
   			pNode = head;
   			next = head.next;
   			for(int i=0; i<idx; i++) // 해당 index 위치 전까지 이동
   			{
   				prev = pNode;
   				pNode = pNode.next;   
   			}
   			next = pNode.next;
   			prev.next = next;
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

