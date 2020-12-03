package _009��ü����;

// Java���� �⺻������ Ŭ������ �����ϸ� ObjectŬ������ ��ӹ��� 
// �ϱ� hashCode(), equals(), toString()���� ObjectŬ�������� ���ǵǾ� �����Ƿ�
// �ڽ�Ŭ�������� �������ؼ� ��밡��
// �߻�Ŭ����(�߻�޼��带 �ϳ��� ������ �ִ� Ŭ����)������ ���� abstract Ű���� ���
abstract class Car {
	protected int year=2010;
	protected int fuel;
	
	public Car(int oil) {
		fuel=oil;
		System.out.println("�θ� Ŭ���� ������ ȣ��");
	}
	
	public void showFuel() {
		System.out.println(fuel);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	// �߻�޼���
	// ���� �س��� ���ǵ��� ���� �޼���
	// �ڽ�Ŭ�������� �������̵��� ���� ���� ����
	public abstract void showInfo();
	
}

// super()�����ڸ� ���� �θ�Ŭ������ �����ڸ� ȣ���ϸ�,
// super���۷����� ���� �θ�Ŭ������ �޼ҵ忡 �����Ҽ� ����.(private���� ����� ���� ����)
class Truck extends Car{
	
	public Truck(int extraOil)
	{
		super(10 + extraOil);
	}
	
	public void showInfo() {
		System.out.println(super.year);
		super.showFuel();
	}
}

class SportCar extends Car{
	
	public SportCar(int extraOil)
	{
		super(10 + extraOil);
	}
	
	public void showInfo() {
		System.out.println("==============");
		System.out.println(super.year);
		super.showFuel();
		System.out.println("===============");
	}
}

// �������̽�: ��� �޼��尡 ���� �Ǿ��ְ� �������� ���� Ŭ����
// �ش� �������̽��� implements�� Ŭ������ �������̽��� ��� �޼��带 �����ؾ���.
// ���� �� �������� �ʴ´ٸ� �ش� Ŭ������ �߻�Ŭ������ �Ǿ�� ��
interface Phone{
	public void call();
	public void sendMessage();
}

class SmartPhone implements Phone{

	@Override
	public void call() {
		System.out.println("call");
		
	}

	@Override
	public void sendMessage() {
		System.out.println("send kakaotalk msg");
	
	}
	
}

// �������̽��� Phone�� �޼��带 �� �������� �ʾұ� ������ �߻�Ŭ����
abstract class FolderPhone implements Phone{

	@Override
	public void call() {
		System.out.println("call");		
	}
	
}

// ������ �޼��带 ����
class RazorPhone extends FolderPhone{

	@Override
	public void sendMessage() {
		System.out.println("open phone");
		System.out.println("send text msg");
	}
	
}

public class Inherit_Abstract_InterfaceTest {

	public static void main(String[] args) {
		// ������: �θ�Ŭ���� �ڷ������� �ڽ�Ŭ�������� �����ϰ�,
		// �������̵��� ���� �θ�Ŭ������ �޼��带 ȣ���ص� �ڽ�Ŭ������ �޼��尡 ȣ��Ǵ� ����
		// �θ�Ŭ������ �ڷ������� �پ��ϰ� ���������� �ڽ�Ŭ������ ����
		Car truck = new Truck(100);
		Car superCar = new SportCar(30);

		truck.showInfo();
		superCar.showInfo();
		
		// instanceof Ű���带 ���� �ٿ�ĳ���� �Ǿ�� ���� �ν��Ͻ��� �ڷ����� Ȯ���� �� �ִ�.
		if(truck instanceof Truck) {
			System.out.println("it is Truck");
		}
		
		if(superCar instanceof Truck) {
			System.out.println("it is Truck");
		}
		else {
			System.out.println("it is not Truck");
		}
	}

}
