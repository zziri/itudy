package genericClass;

public class Powder extends Material{
	
	@Override
	public String toString() {
		return "재료는 Powder 입니다.";
	}

	@Override
	public void doPrinting() {
		System.out.println("Powder로 Printing합니다.");
		
	}
}
