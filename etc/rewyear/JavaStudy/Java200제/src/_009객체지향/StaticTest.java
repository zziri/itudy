package _009객체지향;

import singletonPattern.Company;

// static 키워드를 이용하게 되면 인스턴스를 생성하지 않고도 해당 클래스 or 인터페이스 이름으로
// 해당 객체의 멤버변수 메소드를 생성할 수 있다.
class Java{	
	public static int serialNumber = 100;
	public static void greeting()
	{
		System.out.println("Hello Java");
	}
}

// static활용1: static과 final을 이용해 상수를 따로 정의해놓은 클래스 만들기
class Defines {
	public static final double PI = 3.14;
	public static final int MAX = 9999;
}

// static활용2: singleton pattern 
class Company {
	private Company() {} // singleton pattern을 위한 private 생성자
	
	// static으로 유일한 객체 생성
	private static Company instance = new Company();
		
	// 외부에서 private인 인스턴스를 얻어갈수 있게 static메서드 정의
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		return instance;
	}
}

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(Java.serialNumber);
		Java.greeting();
	}

}
