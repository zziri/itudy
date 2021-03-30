package DP.ex2;

import java.util.Scanner;

public class Solution {
	public static int[] dp = new int[30001];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int i=2; i<=num; i++)
		{
			// 현재의 수에서 1을 빼는 경우
			dp[i] = dp[i-1] + 1;
			
			// 현재의 수가 2로 나누어 떨어지는 경우
			if(i % 2 == 0)
				dp[i]= Math.min(dp[i], dp[i/2] + 1); // 2를 곱해서 얻어지는 루트가 최소 비용인지 비교 
			
			// 현재의 수가 3로 나누어 떨어지는 경우 
			if(i % 3 == 0)
				dp[i]= Math.min(dp[i], dp[i/3] + 1); // 3를 곱해서 얻어지는 루트가 최소 비용인지 비교
			
			// 현재의 수가 5 로 나누어 떨어지는 경우
			if(i % 5 == 0)
				dp[i]= Math.min(dp[i], dp[i/5] + 1); // 5를 곱해서 얻어지는 루트가 최소 비용인지 비교
			
		}
		
		System.out .println(dp[num]);

	}

}
