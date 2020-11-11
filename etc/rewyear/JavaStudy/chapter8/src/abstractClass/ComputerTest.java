package abstractClass;

public class ComputerTest {

	public static void main(String[] args) {
		Computer com1 = new Desktop();
		com1.display();
		com1.type();
		
		com1.turnOn(); 
	}

}
