package classClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// �����ϵ� class���Ͽ��� ��ü�� ����(�������, �޼���, ������ ��)�� ���ԵǾ� �ִµ�
// ClassŬ������ ���� �����ϵ� class���Ͽ��� ��ü�� ������ ������ �� ����.

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// 1. Object Ŭ������ getClass �޼��带 Ȱ���Ͽ� ClassŬ������ ������.
		String s = new String();
		Class c1 = s.getClass();
		
		// 2. ���� Ŭ������ classŬ���� ������.
		Class c2 = String.class;
		
		// 3. ���� �ε�(���ÿ� �ش� �ڷ����� ����, ��Ÿ�ӿ� �����;� �ϴ� ���)
		// �̷� Ư�������� reflection ���α׷����� �� �� ����.
		Class c3 = Class.forName("java.lang.String"); // ClassŬ������ static �ż���
		
		Constructor[] cons = c3.getConstructors();
		Method[] methods = c3.getMethods();
		
		for(Constructor con : cons)
		{
			System.out.println(con);
		}
		System.out.println("--------------------------------------------------");
		for(Method method : methods)
		{
			System.out.println(method);
		}
		
	}

}
