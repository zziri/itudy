package genericClass;

// ���׸� Ÿ�� T �ڿ� Ư��Ŭ������ extends�ϰ� �Ǹ� Material�� ��ӹ��� Ŭ������ �ش� ���׸� Ŭ������ ����Ҽ� ����.
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
