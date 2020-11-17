package interfaceBasic;

// 여러 개의 인터페이스를 구현한 Customer class
public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		System.out.println("Customer Sell");
		
	}

	@Override
	public void buy() {
		System.out.println("Customer Buy");
		
	}

	// 각각의 인터페이스를 구현하는데 메서드가 중복되므로 재정의 
	@Override
	public void order() {
		System.out.println("Customer Order");
	}
	
	public void sayHello() {
		System.out.println("Hello");
	}
	

}
