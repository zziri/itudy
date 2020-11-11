package template_final;

public class CarTest {

	public static void main(String[] args) {
		Car aiCar = new AICar();
		Car manualCar = new ManualCar();
		
		// run() 메서드는 추상클래스인 Car에서 final을 이용하여 템플릿 메서드로 정의
		// 프레임 워크에서 동작시나리오가 정해져 있으며, 하위 클래스에서 일부만 바꿔줘야하는 경우 
		// 추상 클래스에서 템플릿 메서드를 정의해주고, 하위 클래스는 해당 클래스에 맞게 재정의 
		aiCar.run();
		System.out.println("=================");
		manualCar.run();

	}

}
