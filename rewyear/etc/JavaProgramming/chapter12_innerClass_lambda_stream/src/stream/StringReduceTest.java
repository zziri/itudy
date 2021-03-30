package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{

	@Override
	public String apply(String t, String u) {
		if(t.getBytes().length >= u.getBytes().length)
			return t;
		else 
			return u;
	}
	
}

public class StringReduceTest {

	public static void main(String[] args) {
		String[] greeting = {"Hello","Hi","Good morning","Nice to meet you"};
		
		System.out.println(Arrays.stream(greeting).reduce("",(s1,s2)->
		{
			if(s1.getBytes().length >= s2.getBytes().length)
				return s1;
			else 
				return s2;
		}
		));
		
		// ���� reduce() �޼��忡 ���ٽ� ��� ���� ������ class�ν��Ͻ� ����.
		System.out.println(Arrays.stream(greeting).reduce("",new CompareString()));

	}

}
