package stream.decoratorPattern;

public class CoffeeTest {

	public static void main(String[] args) {
		Coffee americanoKenya = new KenyaAmericano();
		Coffee latte = new Latte(americanoKenya);
		latte.brewing();
		
		Coffee americanoEtiopia = new EtiopiaAmericano();
		Coffee mocha = new Mocha(latte);
		mocha.brewing();

	}

}
