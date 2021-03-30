package _009객체지향;

// Java에서 기본적으로 클래스를 생성하면 Object클래스를 상속받음 
// 하기 hashCode(), equals(), toString()등은 Object클래스에서 정의되어 있으므로
// 자식클래스에서 재정의해서 사용가능
// 추상클래스(추상메서드를 하나라도 가지고 있는 클래스)선언을 위해 abstract 키워드 사용
abstract class Car {
	protected int year=2010;
	protected int fuel;
	
	public Car(int oil) {
		fuel=oil;
		System.out.println("부모 클래스 생성자 호출");
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
	
	// 추상메서드
	// 선언만 해놓고 정의되지 않은 메서드
	// 자식클래스에서 오버라이딩을 통해 실제 구현
	public abstract void showInfo();
	
}

// super()생성자를 통해 부모클래스의 생성자를 호출하며,
// super레퍼런스를 통해 부모클래스의 메소드에 접근할수 있음.(private으로 선언된 것은 제외)
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

// 인터페이스: 모든 메서드가 선언만 되어있고 구현되지 않은 클래스
// 해당 인터페이스를 implements할 클래스는 인터페이스의 모든 메서드를 구현해야함.
// 만약 다 구현하지 않는다면 해당 클래스는 추상클래스가 되어야 함
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

// 인터페이스인 Phone의 메서드를 다 구현하지 않았기 때문에 추상클래스
abstract class FolderPhone implements Phone{

	@Override
	public void call() {
		System.out.println("call");		
	}
	
}

// 나머지 메서드를 구현
class RazorPhone extends FolderPhone{

	@Override
	public void sendMessage() {
		System.out.println("open phone");
		System.out.println("send text msg");
	}
	
}

public class Inherit_Abstract_InterfaceTest {

	public static void main(String[] args) {
		// 다형성: 부모클래스 자료형으로 자식클래스들을 참조하고,
		// 오버라이딩을 통해 부모클래스의 메서드를 호출해도 자식클래스의 메서드가 호출되는 형태
		// 부모클래스의 자료형으로 다양하고 여러가지의 자식클래스를 관리
		Car truck = new Truck(100);
		Car superCar = new SportCar(30);

		truck.showInfo();
		superCar.showInfo();
		
		// instanceof 키워드를 통해 다운캐스팅 되었어도 실제 인스턴스의 자료형을 확인할 수 있다.
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
