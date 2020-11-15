package abstractClass;

// 추상 클래스를 상속받아 실제 구현이 이뤄지는 하위 클래스
// 모든 메서드가 구현되었다고 해도 클래스에 abstract키워드를 사용하면 추상클래스
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
