package interfaceBasic;

// ���� ���� �������̽��� ������ Customer class
public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		System.out.println("Customer Sell");
		
	}

	@Override
	public void buy() {
		System.out.println("Customer Buy");
		
	}

	// ������ �������̽��� �����ϴµ� �޼��尡 �ߺ��ǹǷ� ������ 
	@Override
	public void order() {
		System.out.println("Customer Order");
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}
	

}
