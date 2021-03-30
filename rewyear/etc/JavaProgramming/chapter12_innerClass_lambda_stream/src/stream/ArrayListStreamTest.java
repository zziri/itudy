package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>(); // List�������̽��� ��ĳ����
		
		sList.add("Yohan");
		sList.add("Fred");
		sList.add("David");
		sList.add("Allen");
		
		// Stream ��ü�� ������ ��� ���.
		Stream<String> stream = sList.stream();
		stream.forEach(s->System.out.print(s + " "));
		System.out.println();
		
		sList.stream().sorted().forEach(s->System.out.print(s + " "));
		System.out.println();
		
		sList.stream().map(s->s.length()).forEach(n->System.out.println(n));
	}

}
