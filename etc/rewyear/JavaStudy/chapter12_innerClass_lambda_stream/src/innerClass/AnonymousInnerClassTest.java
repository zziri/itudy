package innerClass;

class Outer2{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;

		// �͸� ���� Ŭ����
		// ���� ���� Ŭ����(�̸�)�� ���� �������� �ʰ�, return �ϴ� ������ ���ǿ� ���ÿ� ����
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
