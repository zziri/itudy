package interfaceBasic;

public interface Calc {
	double PI = 3.14;
	int ERROR = -9999999;
	
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
		//myMethod();
	}
	
	// 정적 메서드이므로 인터페이스를 구현한 클래스의 인스턴스를 생성하지 않더라도 사용 가능
	static int total(int[] arr) {
		int total=0;
		
		for(int i: arr)
		{
			total+=i;
		}
		
		//myStaticMethod();
		return total;
	}
	
	/* java9 부터 제공되는 인터페이스의 private 메서드
	private void myMethod() {
		System.out.println("private method");
	}
	
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
	
	*/
}
