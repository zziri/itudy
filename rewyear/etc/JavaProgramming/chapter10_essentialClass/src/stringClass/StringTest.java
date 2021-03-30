package stringClass;

public class StringTest {

	public static void main(String[] args) {
		
		// 인스턴스 생성
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1 == s2);
		
		// 상수 pool에서 가져옴
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3 == s4);
	}

}
