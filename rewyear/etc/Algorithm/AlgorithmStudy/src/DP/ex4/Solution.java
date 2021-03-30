package DP.ex4;

import java.util.Scanner;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[1001];
		
		int N = sc.nextInt();
		int cnt = 0;
		
		dp[1] = 1;
		dp[2] = 3;
				
		for(int i = 3; i<=N; i++)
		{
			dp[3] = (dp[i-1] + 2*dp[i-2]) % 796796;
		}
		
		System.out.println(dp[N]);
	}
	public static void main(String[] args) {
		sol();

	}

}
