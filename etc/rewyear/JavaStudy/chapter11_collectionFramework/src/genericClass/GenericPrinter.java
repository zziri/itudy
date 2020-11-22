package genericClass;

// 제네릭 타입 T 뒤에 특정클래스를 extends하게 되면 Material을 상속받은 클래스만 해당 제네릭 클래스를 사용할수 있음.
public class GenericPrinter<T extends Material> {
	private T material;

	public T getMeterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}

	public String toString() {
		return material.toString();
	}
	
	public void printing()
	{
		material.doPrinting();
	}
	
	
	
	
}
