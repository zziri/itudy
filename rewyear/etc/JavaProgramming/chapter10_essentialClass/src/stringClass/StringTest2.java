package stringClass;

public class StringTest2 {

	public static void main(String[] args) {
		
		String java = new String("java");
		String android = new String("android");
		System.out.println(System.identityHashCode(java)); //1
		
		java = java.concat(android); // 3
		
		System.out.println(java);
		
		System.out.println(System.identityHashCode(java)); //2
		
		// �Ȱ��� �ν��Ͻ� java�� 1�� �ּҰ��� 2�� �ּҰ� �ٸ� -> �� 3���� ���ο� ���ڿ��� �����Ͽ� ����Ǳ� ������ �ּ� ���̸� ����
		// �̷� ���� ������ �޸� ���� �߻��� �� ���� �̸� ���� ����ϴ°��� StringBuilder�� StringBuffer\
		
		

	}

}
