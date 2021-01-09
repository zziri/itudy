package DP.ex3;

import java.util.Scanner;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		// dp 테이블
		int[] dp = new int[100];
		
		// 식량 정보 입력
		int[] arr = new int[cnt];
		for(int i=0; i<cnt; i++)
			arr[i] = sc.nextInt();
		
		//
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2; i<cnt; i++)
		{
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
		}
		
		System.out.println(dp[cnt-1]);
		
	}
	public static void main(String[] args) {
		sol();

	}

}
