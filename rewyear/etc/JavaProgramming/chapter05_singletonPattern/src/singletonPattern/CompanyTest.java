package singletonPattern;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();

		// ������ ��ü���� Ȯ���ϱ� ���� �ּ� �� ��
		System.out.println(company1);
		System.out.println(company2);
		
		// Java���� Singleton Pattern�� Ȱ��� ��		
		Calendar calendar = Calendar.getInstance();
	}

}
