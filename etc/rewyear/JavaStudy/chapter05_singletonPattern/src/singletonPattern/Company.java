package singletonPattern;

public class Company {
	private Company() {} // singleton pattern을 위한 private 생성자
	
	// static으로 유일한 객체 생성
	private static Company instance = new Company();
		
	// 외부에서 private인 인스턴스를 얻어갈수 있게 static 메서드 정의
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		
		return instance;
	}
}
