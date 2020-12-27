package sortInterfaceEx;

public interface Sort {
	void ascending(int[] arr);
	void descending(int[] arr);
	
	// 인터페이스의 디폴트 메서드
	default void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
	}
}
