package abstractClass;

// �߻� Ŭ������ ��ӹ޾� ���� ������ �̷����� ���� Ŭ����
// ��� �޼��尡 �����Ǿ��ٰ� �ص� Ŭ������ abstractŰ���带 ����ϸ� �߻�Ŭ����
public class Desktop extends Computer {

	@Override
	public void display() {
		System.out.println("Desktop Display");
		
	}

	@Override
	public void type() {
		System.out.println("Desktop Typing");
		
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Desktop On");
	}
	
	

}
