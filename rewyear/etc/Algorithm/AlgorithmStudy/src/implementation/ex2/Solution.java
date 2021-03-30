package implementation.ex2;

import java.util.Scanner;

public class Solution {
	public static void sol1()
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
	
	public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }
	
	public static void sol2()
	{
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                }
            }
        }
		
        System.out.println(cnt);
		
	}
	
	public static void main(String[] args) {
		long start, end;
		
		start = System.currentTimeMillis();
		sol1();
		end = System.currentTimeMillis();
		
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		sol2();
		end = System.currentTimeMillis();
		
		System.out.println(end-start);

	}

}
