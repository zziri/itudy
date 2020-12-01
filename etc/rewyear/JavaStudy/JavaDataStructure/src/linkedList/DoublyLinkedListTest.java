package linkedList;

public class DoublyLinkedListTest {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dLinkedList = new DoublyLinkedList<Integer>(); 
		
		dLinkedList.addLast(1);
		dLinkedList.addLast(2);
		dLinkedList.addLast(3);
		dLinkedList.addLast(4);
		dLinkedList.addLast(5);
		System.out.println(dLinkedList.getSize());
		
		dLinkedList.remove(2);
		dLinkedList.remove(3);
		System.out.println(dLinkedList);
		
		dLinkedList.add(2,10);
		System.out.println(dLinkedList);
		
		dLinkedList.addFirst(100);
		System.out.println(dLinkedList);
		
		dLinkedList.addLast(33);
		System.out.println(dLinkedList);
	}

}
