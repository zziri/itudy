package classClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

// 컴파일된 class파일에는 객체의 정보(멤버변수, 메서드, 생성자 등)이 포함되어 있는데
// Class클래스를 통해 컴파일된 class파일에서 객체의 정보를 가져올 수 있음.

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// 1. Object 클래스의 getClass 메서드를 활용하여 Class클래스를 가져옴.
		String s = new String();
		Class c1 = s.getClass();
		
		// 2. 직접 클래스의 class클래스 가져옴.
		Class c2 = String.class;
		
		// 3. 동적 로딩(로컬에 해당 자료형이 없어, 런타임에 가져와야 하는 경우)
		// 이런 특성때문에 reflection 프로그래밍을 할 수 있음.
		Class c3 = Class.forName("java.lang.String"); // Class클래스의 static 매서드
		
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
