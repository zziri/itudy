package implementation.ex4_2시각;

import java.util.Scanner;

public class Solution {
	public static void sol()
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		int sec = 0;
		
		while(sec < 3600*(N+1)) {
			StringBuilder strBuilder = new StringBuilder();
			int curr = sec;
			int h = curr / 3600; // 시
			curr %= 3600;
			
			int m = curr / 60; // 분
			int s = curr % 60; // 초
			
			// 시,분,초를 이어 붙여 hhmmss 포맷의 문자열을 만듬
			strBuilder.append(h);
			strBuilder.append(m);
			strBuilder.append(s);
			
			String time = strBuilder.toString();
			if(time.contains("3"))
				cnt++;
			
			sec++; // 1초 증가
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		sol();

	}

}
