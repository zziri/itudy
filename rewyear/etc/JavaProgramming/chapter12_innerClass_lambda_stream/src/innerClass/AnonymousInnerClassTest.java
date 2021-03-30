package innerClass;

class Outer2{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;

		// 익명 내부 클래스
		// 지역 내부 클래스(이름)를 따로 정의하지 않고, return 하는 곳에서 정의와 동시에 리턴
		return new Runnable() {
			@Override
			public void run() {
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(sNum);
			}
		};
		
	}
}

public class AnonymousInnerClassTest {

	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Runnable runnable = outer.getRunnable(123);
		
		runnable.run();

	}

}
