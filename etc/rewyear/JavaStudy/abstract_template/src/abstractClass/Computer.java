package abstractClass;

//abstract Ű���带 �̿��Ͽ� �߻�Class ����
public abstract class Computer {
	
	// abstract Ű���带 �̿��Ͽ� �߻� method ����
	public abstract void display();
	public abstract void type();
	
	// �⺻���� method
	public void turnOn() {
		System.out.println("������ �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("������ ���ϴ�.");
	}
}

// abstract�� �̿��Ͽ� �߻�Ŭ������ ����� �̸� ��ӹ��� ����Ŭ�������� abstract method ���� ����