package stringClass;

public class StringTest {

	public static void main(String[] args) {
		
		// �ν��Ͻ� ����
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		
		// ��� pool���� ������
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3 == s4);
	}

}
