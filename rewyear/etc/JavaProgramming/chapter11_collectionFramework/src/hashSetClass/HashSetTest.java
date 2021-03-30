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
		
		// Set�������̽��� ������ ���� ������ List�������̽��ʹ� �ٸ��� ���� ������� ��µ��� ����.
		System.out.println(set);
		
		Iterator<String> ir = set.iterator();
		
		// Set�������̽��� ��� �ε����� �������� ���ϱ� ������ ��ȸ�� ���ؼ�  
		// Iterator�� hasNext() �޼��带 �̿��ؼ� ���� ��Ұ� �ִ��� Ȯ��
		while(ir.hasNext()) {
			String str = ir.next();
			System.out.println(str);
		}
	}

}
