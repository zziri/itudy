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
                    // �� �ð� �ȿ� '3'�� ���ԵǾ� �ִٸ� ī��Ʈ ����
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
