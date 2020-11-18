package objectClass;

class Book implements Cloneable{
	String title;
	String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return author + "," + title;
	}
	
	// Clone() 메서드
	// 객체의 복사본을 만드는 메서드로서 같은 속성 값을 가진 객체의 복사본을 생성할수 있음.
	// 정보은닉에 위배될 가능성이 있으므로 cloneable 인터페이스를 명시해야 함.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// 기본적으로 Object의 toString 메서드는 객체의 정보 출력(클래스, 주소 값)
public class ToString_CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("복학왕", "기안84");
		System.out.println(book);
		
		// Object의 toString을 String class에서 재정의 했기 때문에 문자열이 출력.
		String str = new String("토지");
		System.out.println(str);
		
		Book book2 = (Book)book.clone();
		System.out.println(book2);

	}

}
