package stringClass;

public class StringTest2 {

	public static void main(String[] args) {
		
		String java = new String("java");
		String android = new String("android");
		System.out.println(System.identityHashCode(java)); //1
		
		java = java.concat(android); // 3
		
		System.out.println(java);
		
		System.out.println(System.identityHashCode(java)); //2
		
		// 똑같은 인스턴스 java의 1의 주소값과 2의 주소값 다름 -> 즉 3에서 새로운 문자열을 생성하여 저장되기 때문에 주소 차이를 보임
		// 이런 현상 때문에 메모리 낭비가 발생할 수 있음 이를 위해 사용하는것이 StringBuilder와 StringBuffer\
		
		

	}

}
