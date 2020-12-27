package innerClass;

class OutClass{
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;
	
	public OutClass() {
		inClass = new InClass();
	}
		
	class InClass{
		int iNum = 100;
		// 인스턴스 내부 클래스의 경우 외부클래스가 생성되야 생성되기 때문에 하기와 같은 코드는 오류 발생
		// 오류가 발생하지 않기 위해서는 내부클래스를 static으로 선언해줘야 함.
		// static int sInNum = 200;
		
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}	
	}
	
	// inClass가 private이므로 하기와 같은 방법으로 내부클래스 호출
	public void usingInner() {
		inClass.inTest();
	}
	
	static class InStaticClass{
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
		
		static void sTest()
		{
			// inNum의 경우 static클래스의 멤버변수이기는 하지만 실제 인스턴스가 생성되야 생성되는 멤버변수이므로
			// static클래스의 static 함수에서는 inNum 호출 불가능
			// System.out.println(inNum);
			System.out.println(sInNum);
			System.out.println(sNum);
		}
	}
}

public class InnerTest {

	public static void main(String[] args) {
		OutClass outClass = new OutClass();
		outClass.usingInner();

	}

}
