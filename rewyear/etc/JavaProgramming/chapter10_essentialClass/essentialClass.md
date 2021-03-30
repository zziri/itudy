## Object 클래스
모든 클래스의 최상위 클래스로서 모든 클래스는 이 Object 클래스를 상속 받음   
상속받았기 때문에 Object 클래스의 메서드를 사용하거나, 일부 메서드들은 재정의하여 사용할 수 있음.   



## Class 클래스

컴파일된 class파일에는 객체의 정보(멤버변수, 메서드, 생성자 등)이 포함되어 있는데   
Class클래스를 통해 컴파일된 class파일에서 객체의 정보를 가져올 수 있음.   



## reflection 프로그래밍

Class 클래스로 부터 객체의 정보를 가져와 프로그래밍 하는 방식으로서, 주로 로컬에 해당 객체가 없어 자료형을 알 수 없는 경우 유용한 프로그래밍 방법.   
java.lang.reflect 패키지에 있는 클래스 활용.   

```
/* Class클래스의 getConstructor() 메서드를 활용하기 위해 찾고 싶은 생성자 매개변수 형태를 Class클래스 배열에 기입하고, 이를 인자로 사용하면 해당 형태의 매개변수를 가진 생성자를 리턴해 줌 */
Class c = Class.forName("classClass.Person"); // 동적 로딩
Person person1 =(Person)c.newInstance(); // newInstance() 메서드 사용하여, 동적할당 및 디폴트 생성자 호출
System.out.println(person1);

/* Class클래스의 getConstructor() 메서드를 활용하기 위해 찾고 싶은 생성자 매개변수 형태를 Class클래스 배열에 기입하고, 이를 인자로 사용하면 해당 형태의 매개변수를 가진 생성자를 리턴해 줌 */
Class[] parameterTypes = {String.class, int.class};
Constructor cons = c.getConstructor(parameterTypes);
	
Object[] initargs = {"Lee",30};
Person person2 = (Person)cons.newInstance(initargs);
System.out.printf("name: %s, age: %d",person2.getName(),person2.getAge());
```



##  String은 immutable

한번 선언되거나 생성된 문자열을 변경할 수 없음   
String클래스의 concat() 메서드 혹은 "+"를 이용하여 String을 연결하는 경우 기존문자열이 변경되는 것이 아니라 새로운 문자열이 생성됨!   
이런 현상때문에 메모리 낭비가 발생할 수 있음. 이를 위해 사용하는것이 StringBuilder 와 StringBuffer   



## StringBuilder와 StringBuffer

가변적인 char[] 배열을 멤버변수로 가지고 있는 클래스로서 문자열을 변경하거나 연결할 때 사용하면 편리한 클래스

* Stri ngBuffer는 멀티 쓰레드 프로그래밍에서 동기화가 보장됨(StringBuilder는 보장 X)
* 단일 쓰레드 프로그래밍에서는 StringBuilder를 사용하는 것이 좋음
* String형으로 변환하기 위해서 toString사용



## Wrapper 클래스

| **기본형** | **Wrapper클래스** |
| ---------- | ----------------- |
| boolean    | Boolean           |
| byte       | Byte              |
| char       | Character         |
| short      | Short             |
| int        | Integer           |
| long       | Long              |
| float      | Float             |
| double     | Double            |