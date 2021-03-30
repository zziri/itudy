package hashSetClass;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("Jone");
		set.add("Kelly");
		set.add("Anna");
		set.add("Kim");
		set.add("Sam");
		
		// Set인터페이스는 순서가 없기 때문에 List인터페이스와는 다르게 삽입 순서대로 출력되지 않음.
		System.out.println(set);
		
		Iterator<String> ir = set.iterator();
		
		// Set인터페이스의 경우 인덱스로 접근하지 못하기 때문에 순회를 위해서  
		// Iterator의 hasNext() 메서드를 이용해서 다음 요소가 있는지 확인
		while(ir.hasNext()) {
			String str = ir.next();
			System.out.println(str);
		}
	}

}
