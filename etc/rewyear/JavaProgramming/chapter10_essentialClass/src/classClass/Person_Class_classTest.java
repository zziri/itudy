package classClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Person_Class_classTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
								IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Person person = new Person("Park");
		System.out.println(person);
		
		Class c = Class.forName("classClass.Person"); // ���� �ε�
		Person person1 =(Person)c.newInstance(); // newInstance() �޼��� ����Ͽ�, �����Ҵ� �� ����Ʈ ������ ȣ��
		System.out.println(person1);

		/* ClassŬ������ getConstructor() �޼��带 Ȱ���ϱ� ���� ã�� ���� ������ �Ű����� ���¸� 
		 ClassŬ���� �迭�� �����ϰ�, �̸� ���ڷ� ����ϸ� �ش� ������ �Ű������� ���� �����ڸ� ������ �� */
		Class[] parameterTypes = {String.class, int.class};
		Constructor cons = c.getConstructor(parameterTypes);
		
		Object[] initargs = {"Lee",30};
		Person person2 = (Person)cons.newInstance(initargs);
		System.out.printf("name: %s, age: %d",person2.getName(),person2.getAge());
	}
}
