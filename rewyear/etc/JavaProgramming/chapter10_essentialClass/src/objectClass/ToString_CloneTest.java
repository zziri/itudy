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
	
	// Clone() �޼���
	// ��ü�� ���纻�� ����� �޼���μ� ���� �Ӽ� ���� ���� ��ü�� ���纻�� �����Ҽ� ����.
	// �������п� ����� ���ɼ��� �����Ƿ� cloneable �������̽��� ����ؾ� ��.
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// �⺻������ Object�� toString �޼���� ��ü�� ���� ���(Ŭ����, �ּ� ��)
public class ToString_CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("���п�", "���84");
		System.out.println(book);
		
		// Object�� toString�� String class���� ������ �߱� ������ ���ڿ��� ���.
		String str = new String("����");
		System.out.println(str);
		
		Book book2 = (Book)book.clone();
		System.out.println(book2);

	}

}
