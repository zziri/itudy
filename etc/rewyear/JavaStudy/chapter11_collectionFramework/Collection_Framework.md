# 컬렉션 프레임워크
* 프로그램 구현에 필요한 자료구조와 알고리즘을 구현해 놓은 라이브러리(java.util)   
* 개발에 소요되는 시간을 절약하고 최적화된 라이브러리를 사용할 수 있음.
*  Collection인터페이스와 Map인터페이스로 구성됨.



## 제네릭 프로그래밍
변수의 선언이나 메서드의 매개변수를 하나의 참조형이 아닌 여러 자료형으로 변환해서 사용할수 있도록 프로그래밍 하는 방식(C++의 템플릿과 유사)

```
public class GenericPrinter<T> {// T: 제네릭 클래스, type의 의미로 T 사용
	private T material;
	
	public void setmaterial(T material){
		this.material = material;
	}
	
	public T getmaterial(){
		return this.material;
	}
}

```



#### 제네릭 메서드

메서드의 매개변수를 자료형 매개변수로 사용하는 메서드
메서드 내에서의 자료형 매개변수는 메서드 내에서만 유효(지역변수 개념)
```
// Shape의 T와 makeRectangle T는 다른 의미
class Shape<T> {
	public staitc <T,V> double makeRectangle(Point<T,V> p1, Point<T,V> p2){
	
	}
}
```



## Collection 인터페이스
**하나의 객체**의 관리를 위해 선언된 인터페이스로 필요한 기본 메서드가 선언되어 있음.
하위에 List, Set 인터페이스가 있음.   



#### List 인터페이스: ArrayList, Vector, LinkedList 등
* 객체를 순서에 따라 저장하고 관리할때 사용하는 메서드가 선언된 인터페이스
* 배열의 기능을 구현하기 위한 메서드가 선언됨

**ArrayList와 Vector: ** 객체 배열 클래스로서 일반적으로는 ArrayList를 더 많이 사용하나 동기화를 위해서는 Vector를 사용.    

**ArrayList와  LinkedList:**  ArrayList의 경우 배열을 구현한 클래스로 논리적 순서와 물리적 순서가 동일.   
LikedList의 경우 논리적으로 순차적인 구조이나 물리적으로는 순차적이지 않음.   
(LikedList의 요소는 다음 LikedList의 요소의 주소를 가르키기 때문)   
때문에 중간의 요소 추가나 삭제시 ArrayList보다 overhead가 적음



#### Set 인터페이스: HashSet, TreeSet

* List 인터페이스와는 다르게  순서가 정해져 있지 않음, 중복을 허용하지 않음.
* 해당 객체를 순환하기 위해서는 **Iterator**로 순회해야 함.
|method|description|
|---|---|
|boolean hasNext()|이후에 요소가 더 있는지를 체크하는 메서드이며, 다음 요소가 있다면 true|
|E next()|다음에 있는 요소를 반환|

**HashSet: ** 중복을 허용하지 않으므로 저장되는 객체의 동일함 여부를 알기 위해 equals(), hashCode() 메서드를 재정의 해야함.   

**TreeSet: ** binary search tree로 구현되어 있으며, 오름차순이나 내림차순으로 객체를 정렬 함.   
정렬을 위해서 Comparable or Comparator 인터페이스 구현해줘야함.

* Comparable인터페이스 구현시:  compareTo() 메서드 재정의 해줘야 함   
-> compareTo()양수 반환: 오름차순, 음수 반환: 내림차순 

* Comparator인터페이스 구현시:  compare() 메서드 재정의 해줘야 함   

  -> compareTo()와 유사하나 매개변수가 2개 들어옴. 양수 반환: 오름차순, 음수 반환: 내림차순 

  ```
 public int compare(Obj o1, Obj o2) 
  ```
  
  -> TreeSet 인스턴스 생성시 객체를 하나 삽입해 줘야함(그래야 첫 삽입시 비교할 대상인 o1 생김)
  
  ```
  private TreeSet<Member> treeSet;
  public void MemeberTreeSet(){
  	treeSet = new TreeSet<Member>(new Member());
  }
  ```





## Map 인터페이스

**<key, value>쌍으로 이루어진 객체**를 관리하는데 필요한 여러 메서드들이 선언되어 있음.
여기서 key는 중복될수 없음.

검색을 위한 자료구조로서 key를 이용하여 값을 저장하거나 검색, 삭제할때 사용화면 편리함. (내부적으로 hash방식으로 구현)

key가 되는 객체는 객체의 유일하다는 여부를 알기위해 equals()와 hashCode() 메서드를 재정의 해야함.

**HashMap:** Map인터페이스를 구현한 클래스 중 가장 일반적으로 사용하는 클래스. pair 자료를 쉽고 빠르게 관리할 수 있음.

**TreeMap:** key객체를 기준으로 정렬하여 <key, value> pair로 관리하는 클래스로서 TreeSet과 마찬가지로 Comparable or Comparator 인터페이스를 구현해야함.(대게 구현되어있는 많은 클래스들에는 Comparable이 많이 구현되어 있음.)

