package singletonPattern;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();

		// 유일한 객체인지 확인하기 위해 주소 값 비교
		System.out.println(company1);
		System.out.println(company2);
		
		// Java에서 Singleton Pattern이 활용된 예		
		Calendar calendar = Calendar.getInstance();
	}

}
