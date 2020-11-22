package collectionInterface;

import java.util.LinkedList;

public class ListTest {

	public static void main(String[] args) {
		LinkedList<Member> linkedList = new LinkedList<Member>(); 
		
		linkedList.add(new Member(100, "KIM"));
		linkedList.add(new Member(101, "LEE"));
		linkedList.add(new Member(102, "PARK"));
		
		System.out.println(linkedList);
		
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());
		System.out.println(linkedList.get(1));
		
		// index�� ���ڷ� �̿��Ͽ� �ش� ��ġ�� ����
		linkedList.add(1,new Member(244,"JUNG"));
		System.out.println(linkedList.get(1));
		
		// index�� ����
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}

	}

}
