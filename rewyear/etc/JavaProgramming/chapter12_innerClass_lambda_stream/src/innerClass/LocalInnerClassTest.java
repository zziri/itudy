package innerClass;

class Outer{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		// ���� ���� Ŭ����
		class MyRunnable implements Runnable{

			@Override
			public void run() {
				// ���� ���� Ŭ������ MyRunnable�� ���� �� ��ȯ�Ǿ� run() ȣ�� ���� ���� ���ɼ� �ֱ⶧����
				// �Լ��� ������ �Ҹ�Ǵ� num, i�� ���� ���������� �� ���� �Ұ�(������ ���������� final�� ���ȭ�ϱ� ������ ������ ����) 
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
