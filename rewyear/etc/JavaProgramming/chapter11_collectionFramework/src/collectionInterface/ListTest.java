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
		
		// index를 인자로 이용하여 해당 위치에 삽입
		linkedList.add(1,new Member(244,"JUNG"));
		System.out.println(linkedList.get(1));
		
		// index로 접근
		for(int i=0; i<linkedList.size(); i++) {
			System.out.println(linkedList.get(i));
		}

	}

}
