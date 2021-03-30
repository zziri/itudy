package template_final;

public abstract class Car {
	public abstract void drive();
	public abstract void stop();
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	// final 키워드를 이용하여 템플릿 메서드 정의, 템플릿 메서드의 경우 하위클래스에서 오버라이드 할 수 없음.
	final public void run() {
		startCar();
		drive();
		stop();
		turnOff();
	}
}
