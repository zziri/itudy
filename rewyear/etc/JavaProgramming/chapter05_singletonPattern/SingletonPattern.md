## Singleton Pattern
최초 한 번 객체 생성 후 사용되는 인스턴스로서, 프로그램에서 유일하게 존재하는 객체이며 재사용이 가능하므로 메모리 낭비를 막을수 있다. but, 단점으로는 전역성(global)의 특징을 가지고 있기 때문에 
* 생성자를 private으로 정의.   
* 외부에서 유일하게 객체를 참조할 수 있도록 **public static getInstance()** 구현



#### 기본적인 Singleton pattern
가장 기본적인 Singleton Pattern으로서, 인스턴스가 사용되는 시점이 아닌 클래스 로딩 시점에 인스턴스가 생성되어버린다는 단점이 있다.
```
public class Company {
	private Company() {} // singleton pattern을 위한 private 생성자
	
	// static으로 유일한 객체 생성
	private static Company instance = new Company();
		
	// 외부에서 private인 인스턴스를 얻어갈수 있게 static 메서드 정의
	public static Company getInstance() {		
		return instance;
	}
}
```

#### 늦은 초기화(lazy init) + Thread Safe
위의 기본적인 Singleton Pattern의 단점을 보완하여 인스턴스가 필요한 시점에 생성되는 방식으로 구현과 동시에 synchronized 키워드를 사용하여 Thread-Safe를 보장
```
public class Company{
	private static Company instance;
	
	private Company() {}
	
	public static synchronized Company getInstance() {
		if(instance == null)
			instance = new Company();
		return instance;
	}
}
```

#### Holder
**Java에서 Singleton 생성에 대표적인 방법**으로서, 정적 내부 클래스를 이용하여 구현되는데, 해당 내부 클래스에 대한 멤버변수가 없기때문에 클래스 로더가 초기화 과정을 진행할 때 내부클래스를 초기화 하지 않고 getInstance()를 호출할 때 초기화가 진행됨

InnerInstanceClass() 내부 멤버변수(instance)는 static이기 때문에 클래스 로딩 시점에 한번만 호출될 것이며, final을 사용하여 다시 값이 할당되지 않도록 구현한 방법.

```
public class Company{
	private Company() {}
	
	private static class InnerInstanceClass(){
		private static final Company instance = new Company();
	}
	
	public static Company getInstance() {
		return InnerInstanceClass.instance;
	}
}
```
