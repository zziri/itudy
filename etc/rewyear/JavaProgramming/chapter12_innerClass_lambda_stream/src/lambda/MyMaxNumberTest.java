package lambda;

public class MyMaxNumberTest {

	public static void main(String[] args) {
		MyMaxNumber myMax = (x,y)->(x>y)?x:y;
		System.out.println(myMax.getMaxNumber(123, 132));

	}

}
