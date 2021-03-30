package linkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>(); 
		
		linkedList.addLast(1);
		linkedList.addLast(2);
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		System.out.println(linkedList.getSize());
		
		linkedList.remove(2);
		linkedList.remove(3);
		System.out.println(linkedList);
		
		linkedList.add(2,10);
		System.out.println(linkedList);
		
		linkedList.addFirst(100);
		System.out.println(linkedList);
	}

}
