package sortInterfaceEx;

public interface Sort {
	void ascending(int[] arr);
	void descending(int[] arr);
	
	// �������̽��� ����Ʈ �޼���
	default void description() {
		System.out.println("���ڸ� �����ϴ� �˰����Դϴ�.");
	}
}
