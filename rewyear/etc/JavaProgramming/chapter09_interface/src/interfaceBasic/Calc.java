package interfaceBasic;

public interface Calc {
	double PI = 3.14;
	int ERROR = -9999999;
	
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("���� ���⸦ �����մϴ�.");
		//myMethod();
	}
	
	// ���� �޼����̹Ƿ� �������̽��� ������ Ŭ������ �ν��Ͻ��� �������� �ʴ��� ��� ����
	static int total(int[] arr) {
		int total=0;
		
		for(int i: arr)
		{
			total+=i;
		}
		
		//myStaticMethod();
		return total;
	}
	
	/* java9 ���� �����Ǵ� �������̽��� private �޼���
	private void myMethod() {
		System.out.println("private method");
	}
	
	private static void myStaticMethod() {
		System.out.println("private static method");
	}
	
	*/
}
