package singletonPattern;

public class Company {
	private Company() {} // singleton pattern�� ���� private ������
	
	// static���� ������ ��ü ����
	private static Company instance = new Company();
		
	// �ܺο��� private�� �ν��Ͻ��� ���� �ְ� static �޼��� ����
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		
		return instance;
	}
}
