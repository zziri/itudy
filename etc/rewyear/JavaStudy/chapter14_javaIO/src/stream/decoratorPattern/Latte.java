package stream.decoratorPattern;

// ���� Ŭ�������� ��� Ŭ������ ���δ� Decorator�� ��ӹް� superŰ���带 �̿��Ͽ� ���� Ŭ������ �ν��Ͻ��� ����
// ���� ȣ���ϴ� method���� superŰ���带 �̿��� ����Ŭ������ �޼��带 ���� ȣ�� �� ����Ŭ������ ��� �߰�
public class Latte extends Decorator{
	public Latte(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.println("Adding Milk");
	}

}
