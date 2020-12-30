package implementation.ex4_2�ð�;

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
			int h = curr / 3600; // ��
			curr %= 3600;
			
			int m = curr / 60; // ��
			int s = curr % 60; // ��
			
			// ��,��,�ʸ� �̾� �ٿ� hhmmss ������ ���ڿ��� ����
			strBuilder.append(h);
			strBuilder.append(m);
			strBuilder.append(s);
			
			String time = strBuilder.toString();
			if(time.contains("3"))
				cnt++;
			
			sec++; // 1�� ����
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) {
		sol();

	}

}
