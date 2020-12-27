package innerClass;

class Outer{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		// 지역 내부 클래스
		class MyRunnable implements Runnable{

			@Override
			public void run() {
				// 지역 내부 클래스인 MyRunnable은 생성 후 반환되어 run() 호출 등을 통해 사용될수 있기때문에
				// 함수가 끝나면 소멸되는 num, i와 같은 지역변수는 값 변경 불가(때문에 내부적으로 final로 상수화하기 때문에 참조만 가능) 
				// num += 10;
				// i = 200;
				
				System.out.println(num);
				System.out.println(i);
				System.out.println(outNum);
				System.out.println(sNum);
			}
			
		}
		return new MyRunnable();
	}
}

public class LocalInnerClassTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Runnable runnable = outer.getRunnable(123);
		
		runnable.run();

	}

}
