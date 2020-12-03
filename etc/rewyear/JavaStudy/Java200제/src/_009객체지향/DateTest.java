package _009��ü����;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 1. System.currentTimeMillis() �޼���� 1970.1.1.0.0.0����
		// ������� ����ð��� msec�� ��ȯ 
		long millis = System.currentTimeMillis();
		int day = (int)(millis/1000/60/24); 
		System.out.printf("1970�� 1�� 1�� 0�� 0�� 0�ʷ� ���� %d msec, %d���� ����\n"
				,millis,day);
		
		// 2. Date�� �����ڷ� long���� �����ϸ� Date �������� ��������
		// getTime() �޼���� ����ð��� msec�� ��ȯ
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 24*60*60*1000);
		System.out.println(today);
		System.out.println(tomorrow);
		
		// 3. Calendar�� set() �޼���� ��¥�� ������ ��ü�� ������ �� ����. 
		Calendar cal1970 = Calendar.getInstance();
		cal1970.set(1970, 1-1, 1); // �ڹٿ����� 1~12���� 0~11���� ������ֱ� ������ ��-1		
		
		Calendar todayCal = Calendar.getInstance();
		long minus = todayCal.getTimeInMillis() - cal1970.getTimeInMillis();
		System.out.println(minus);
		
		// 4. SimpleDateFormat�� ���� Date�� ���˿� �°� ��ȯ String�� ������ ����.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(tomorrow);
		System.out.println(str);
	}

}
