package abstractClass;

//추상 클래스의 모든 추상 메서드를 구현하지 않을 것이면 abstract키워드 사용
public abstract class Notebook extends Computer {

	@Override
	public void type() {
		System.out.println("Notebook Typing");
		
	}
	
}
