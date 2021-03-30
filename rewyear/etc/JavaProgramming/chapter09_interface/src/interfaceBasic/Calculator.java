package interfaceBasic;

// interface Calc의 모든 추상메서드를 구현하지 않앗기 때문에 해당 클래스는 추상클래스가 됨
public abstract class Calculator implements Calc{

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
}
