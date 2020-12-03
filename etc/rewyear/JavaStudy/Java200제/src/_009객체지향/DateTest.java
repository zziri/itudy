package _009객체지향;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// 1. System.currentTimeMillis() 메서드는 1970.1.1.0.0.0부터
		// 현재까지 경과시간을 msec로 반환 
		long millis = System.currentTimeMillis();
		int day = (int)(millis/1000/60/24); 
		System.out.printf("1970년 1월 1일 0시 0분 0초로 부터 %d msec, %d일이 지남\n"
				,millis,day);
		
		// 2. Date의 생성자로 long형을 전달하면 Date 포맷으로 변경해줌
		// getTime() 메서드는 현재시간을 msec로 반환
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + 24*60*60*1000);
		System.out.println(today);
		System.out.println(tomorrow);
		
		// 3. Calendar의 set() 메서드로 날짜를 설정한 객체를 생성할 수 있음. 
		Calendar cal1970 = Calendar.getInstance();
		cal1970.set(1970, 1-1, 1); // 자바에서는 1~12월을 0~11월로 사용해주기 때문에 월-1		
		
		Calendar todayCal = Calendar.getInstance();
		long minus = todayCal.getTimeInMillis() - cal1970.getTimeInMillis();
		System.out.println(minus);
		
		// 4. SimpleDateFormat을 통해 Date를 포맷에 맞게 변환 String을 얻을수 있음.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(tomorrow);
		System.out.println(str);
	}

}
