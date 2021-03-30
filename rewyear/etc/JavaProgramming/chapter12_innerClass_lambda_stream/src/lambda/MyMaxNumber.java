package lambda;

// 함수형인터페이스. 내부에는 하나의 함수 선언만 가능 
@FunctionalInterface
public interface MyMaxNumber {
	int getMaxNumber(int x, int y);
}
