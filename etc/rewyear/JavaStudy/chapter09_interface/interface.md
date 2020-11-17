# 인터페이스

## 인터페이스의 역할
* 인터페이스는 클라이언트 프로그램에 어떤 메서드를 제공하는지 알려주는 명세 또는 규약. 프로그램 설계 단계에서 인터페이스를 주로 정의
* 한 객체가 어떤 인터페이스의 타입이라고 함은 그 인터페이스의 메서드를 구현했다는 의미
* 클라이언트 프로그램은 실제 구현내용을 몰라도 인터페이스의 정의만 알면 그 객체를 사용할 수 있음
  ex) JDBS를 구현한 오라클, MSSQL 라이브러리 등

![인터페이스ex](https://github.com/zziri/itudy/blob/master/image/인터페이스ex.png)



## 인터페이스의 요소 

* 추상메서드로만 구성되어 있음(실제 코드의 구현 x)
* 인터페이스에 선언되어 있는 모든 변수들은 상수
* 인터페이스를 구현한 클래스는 인터페이스 타입으로 변수를 선언하여 인스턴스를 생성할 수 있음(클래스의 상속과 다형성) 
* 인터페이스는 구현 코드가 없기 때문에 타입 상속이라고 함.
* 디폴트 메서드 / static 메서드 / private 메서드
  * 디폴트 메서드: 기본 구현을 가지는 메서드, 구현하는 클래스에서 재정의 가능
  * static 메서드: 인스턴스 생성과 상관없이 인터페이스 타입으로 호출하는 메서드
  * private 메서드: 인터페이스 내에서 사용하기 위해 구현한 메서드(java 9부터 지원)



## 여러 개의 인터페이스 구현하기

인터페이스는 구현코드가 없으므로 하나의 클래스가 여러 인터페이스를 구현 할 수 있음   
(java는 c++과 다르게 하나의 클래스만 상속받을 수 있음)   
```
	public class Customer implements Buy, Sell{
		...
	}
```



## 인터페이스 상속

인터페이스 간에도 상속이 가능함(타입상속)   
구현이 없으므로 extends 뒤에 여러 인터페이스를 상속 받을 수 있음  
```
	public interface X{
		void x();
	}
	
	public interface Y{
		void y();
	}

	public interface Z extends X, Y{
		void z();
	}
	
	public class MyClass implements Z{
		@Override
		void x(){
			...
		}
		
		@Override
		void y(){
			...
		}
		
		@Override
		void z(){
			...
		}
	}
```



## 인터페이스의 구현과 클래스 상속

클래스에서 인터페이스 구현과 클래스 상속을 함께 사용할 수 있음
```
	public class BookShelf extends Shelf imelements Queue{
		// Queue 인터페이스에 대한 구현과, Shelf의 메서드 사용 및 재정의 가능
	}
```