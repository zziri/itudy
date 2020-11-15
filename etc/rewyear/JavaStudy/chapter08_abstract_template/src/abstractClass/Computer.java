package abstractClass;

//abstract 키워드를 이용하여 추상Class 정의
public abstract class Computer {
	
	// abstract 키워드를 이용하여 추상 method 정의
	public abstract void display();
	public abstract void type();
	
	// 기본적인 method
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}

// abstract를 이용하여 추상클래스를 만들고 이를 상속받은 하위클래스에서 abstract method 실제 구현