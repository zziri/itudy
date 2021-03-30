package objectEx;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate birthdayKim = new MyDate(11,29);
		MyDate birthdayLee = new MyDate(11,29);
		
		System.out.println(birthdayKim.equals(birthdayLee));
		System.out.println(birthdayKim.hashCode());
		System.out.println(birthdayLee.hashCode());
	}

}
