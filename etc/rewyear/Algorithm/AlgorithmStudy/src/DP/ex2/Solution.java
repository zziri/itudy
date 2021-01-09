package DP.ex2;

import java.util.Scanner;

public class Solution {
	public static int[] dp = new int[30001];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i=2; i<=num; i++)
		{
			// ������ ������ 1�� ���� ���
			dp[i] = dp[i-1] + 1;
			
			// ������ ���� 2�� ������ �������� ���
			if(i % 2 == 0)
				dp[i]= Math.min(dp[i], dp[i/2] + 1); // 2�� ���ؼ� ������� ��Ʈ�� �ּ� ������� �� 
			
			// ������ ���� 3�� ������ �������� ��� 
			if(i % 3 == 0)
				dp[i]= Math.min(dp[i], dp[i/3] + 1); // 3�� ���ؼ� ������� ��Ʈ�� �ּ� ������� ��
			
			// ������ ���� 5 �� ������ �������� ���
			if(i % 5 == 0)
				dp[i]= Math.min(dp[i], dp[i/5] + 1); // 5�� ���ؼ� ������� ��Ʈ�� �ּ� ������� ��
			
		}
		
		System.out .println(dp[num]);

	}

}
