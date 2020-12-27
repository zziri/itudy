package objectClass;

class Student{
	public int id;
	public String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	// 학번이 같으면 동일한 객체라고 하고 싶은 경우
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) 
		{
			Student tmp = (Student) obj; // 다운캐스팅
			if(this.id == tmp.id)
				return true; 
			else 
				return false;
		}
		return false;
	}

	// 대개 equals()를 재정의 하면서, equals()에서 비교에 사용한 멤버를 이용하여 hashCode()의 리턴값으로 사용.
	@Override
	public int hashCode() {
		return id;
	}
}


// 기본적으로 Object클래스의 equals는 물리적 동일함을 반환
// 재정의를 통해 두 객체의 동일함을 논리적으로 판단할 수 있게 재정의할 수 있음.
// 물리적으로 다른 메모리 위치에 존재하는 객체더라도 논리적으로 동일함을 구현하기 위해 사용하는 메서드
public class EqualsTest {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		// 물리적 동일함을 비교
		System.out.println(s1 == s2); 
		// String클래스에서는 equals()를 논리적 동일함을 비교하도록 재정의 했기 때문에 true반환
		System.out.println(s1.equals(s2)); 
		
		
		Student Kim = new Student(100,"KIM RYUN HYUN");
		Student Kim2 = Kim;
		Student Hyun = new Student(100,"KIM RYUN HYUN");
		
		// 물리적으로 같은 메모리 주소를 가리키므로 true 반환
		System.out.println(Kim == Kim2);
		// 논리적으로 동일하므로 true 반환.
		System.out.println(Kim.equals(Hyun));
		
		
		/* Object 클래스의 hashCode()메서드 반환 값의 경우 객체를 식별할 수 있는 값으로서
		   인스턴스가 저장된 가상머신의 주소를 10진수로 반환(실제 메모리의 주소 값이 아님) */
		
		/* 두 개의 서로 다른 메모리에 위치한 인스턴스가 동일하다는 것은 
		1.논리적으로 동일(equals() true)하고, 2.동일한 hashCode를 가짐 */		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		// 논리적으로 동일
		System.out.println(i1.equals(i2));
		// 논리적으로 동일하므로, 동일한 hashcode 반환
		System.out.println(i1.hashCode()); 
		System.out.println(i2.hashCode());
		
		// 실제 메모리 주소를 확인하기 위해서는 System.identityHashCode() 메서드를 활용.
		System.out.println(System.identityHashCode(i1));
		System.out.println(System.identityHashCode(i2));
	}

}
