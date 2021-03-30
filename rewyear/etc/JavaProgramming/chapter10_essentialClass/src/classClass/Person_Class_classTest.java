package classClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Person_Class_classTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
								IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException
	{
		Person person = new Person("Park");
		System.out.println(person);
		
		Class c = Class.forName("classClass.Person"); // 동적 로딩
		Person person1 =(Person)c.newInstance(); // newInstance() 메서드 사용하여, 동적할당 및 디폴트 생성자 호출
		System.out.println(person1);

		/* Class클래스의 getConstructor() 메서드를 활용하기 위해 찾고 싶은 생성자 매개변수 형태를 
		 Class클래스 배열에 기입하고, 이를 인자로 사용하면 해당 형태의 매개변수를 가진 생성자를 리턴해 줌 */
		Class[] parameterTypes = {String.class, int.class};
		Constructor cons = c.getConstructor(parameterTypes);
		
		Object[] initargs = {"Lee",30};
		Person person2 = (Person)cons.newInstance(initargs);
		System.out.printf("name: %s, age: %d",person2.getName(),person2.getAge());
	}
}
