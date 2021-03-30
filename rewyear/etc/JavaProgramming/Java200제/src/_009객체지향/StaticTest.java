package _009��ü����;

import singletonPattern.Company;

// static Ű���带 �̿��ϰ� �Ǹ� �ν��Ͻ��� �������� �ʰ� �ش� Ŭ���� or �������̽� �̸�����
// �ش� ��ü�� ������� �޼ҵ带 ������ �� �ִ�.
class Java{	
	public static int serialNumber = 100;
	public static void greeting()
	{
		System.out.println("Hello Java");
	}
}

// staticȰ��1: static�� final�� �̿��� ����� ���� �����س��� Ŭ���� �����
class Defines {
	public static final double PI = 3.14;
	public static final int MAX = 9999;
}

// staticȰ��2: singleton pattern 
class Company {
	private Company() {} // singleton pattern�� ���� private ������
	
	// static���� ������ ��ü ����
	private static Company instance = new Company();
		
	// �ܺο��� private�� �ν��Ͻ��� ���� �ְ� static�޼��� ����
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
