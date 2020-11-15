package templateEx;

public class PlayerTest {

	public static void main(String[] args) {
		Player p1 = new Player();
		p1.play(1);
		
		p1.upgradeLevel(new AdvancedLevel());
		p1.play(3);

	}

}

