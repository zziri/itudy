package stream.decoratorPattern;

// 보조 클래스에서 기반 클래스를 감싸는 Decorator를 상속받고 super키워드를 이용하여 상위 클래스의 인스턴스를 저장
// 이후 호출하는 method에서 super키워드를 이용해 상위클래스의 메서드를 먼저 호출 후 보조클래스의 기능 추가
public class Latte extends Decorator{
	public Latte(Coffee coffee) {
		super(coffee);
	}
	
	public void brewing() {
		super.brewing();
		System.out.println("Adding Milk");
	}

}
