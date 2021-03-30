package objectClass;

class Student{
	public int id;
	public String name;
	
	public Student(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	// �й��� ������ ������ ��ü��� �ϰ� ���� ���
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) 
		{
			Student tmp = (Student) obj; // �ٿ�ĳ����
			if(this.id == tmp.id)
				return true; 
			else 
				return false;
		}
		return false;
	}

	// �밳 equals()�� ������ �ϸ鼭, equals()���� �񱳿� ����� ����� �̿��Ͽ� hashCode()�� ���ϰ����� ���.
	@Override
	public int hashCode() {
		return id;
	}
}


// �⺻������ ObjectŬ������ equals�� ������ �������� ��ȯ
// �����Ǹ� ���� �� ��ü�� �������� �������� �Ǵ��� �� �ְ� �������� �� ����.
// ���������� �ٸ� �޸� ��ġ�� �����ϴ� ��ü���� �������� �������� �����ϱ� ���� ����ϴ� �޼���
public class EqualsTest {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = new String("abc");
		
		// ������ �������� ��
		System.out.println(s1 == s2); 
		// StringŬ���������� equals()�� ���� �������� ���ϵ��� ������ �߱� ������ true��ȯ
		System.out.println(s1.equals(s2)); 
		
		
		Student Kim = new Student(100,"KIM RYUN HYUN");
		Student Kim2 = Kim;
		Student Hyun = new Student(100,"KIM RYUN HYUN");
		
		// ���������� ���� �޸� �ּҸ� ����Ű�Ƿ� true ��ȯ
		System.out.println(Kim == Kim2);
		// �������� �����ϹǷ� true ��ȯ.
		System.out.println(Kim.equals(Hyun));
		
		
		/* Object Ŭ������ hashCode()�޼��� ��ȯ ���� ��� ��ü�� �ĺ��� �� �ִ� �����μ�
		   �ν��Ͻ��� ����� ����ӽ��� �ּҸ� 10������ ��ȯ(���� �޸��� �ּ� ���� �ƴ�) */
		
		/* �� ���� ���� �ٸ� �޸𸮿� ��ġ�� �ν��Ͻ��� �����ϴٴ� ���� 
		1.�������� ����(equals() true)�ϰ�, 2.������ hashCode�� ���� */		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		// �������� ����
		System.out.println(i1.equals(i2));
		// �������� �����ϹǷ�, ������ hashcode ��ȯ
		System.out.println(i1.hashCode()); 
		System.out.println(i2.hashCode());
		
		// ���� �޸� �ּҸ� Ȯ���ϱ� ���ؼ��� System.identityHashCode() �޼��带 Ȱ��.
		System.out.println(System.identityHashCode(i1));
		System.out.println(System.identityHashCode(i2));
	}

}
