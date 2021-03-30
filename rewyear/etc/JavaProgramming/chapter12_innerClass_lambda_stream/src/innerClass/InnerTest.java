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
		// �ν��Ͻ� ���� Ŭ������ ��� �ܺ�Ŭ������ �����Ǿ� �����Ǳ� ������ �ϱ�� ���� �ڵ�� ���� �߻�
		// ������ �߻����� �ʱ� ���ؼ��� ����Ŭ������ static���� ��������� ��.
		// static int sInNum = 200;
		
		void inTest() {
			System.out.println(num);
			System.out.println(sNum);
		}	
	}
	
	// inClass�� private�̹Ƿ� �ϱ�� ���� ������� ����Ŭ���� ȣ��
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
			// inNum�� ��� staticŬ������ ��������̱�� ������ ���� �ν��Ͻ��� �����Ǿ� �����Ǵ� ��������̹Ƿ�
			// staticŬ������ static �Լ������� inNum ȣ�� �Ұ���
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
