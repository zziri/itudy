package DP.ex5;

import java.util.*;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 화폐의 종류 개수
		int  m = sc.nextInt(); // 거스름돈
		
		// n개의 화폐 단위 정보 입력
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		// dp 테이블 초기화
		int[] dp = new int[m+1];
		Arrays.fill(dp,10001);
		
		dp[0] = 0;
		
		for(int i=0; i<n; i++)
		{
			for(int j=arr[i]; j<=m; j++)
			{
				if(dp[j-arr[i]] != 10001){
					dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
				}
			}
		}
		
		if(dp[m] == 10001)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
		
	}
	public static void main(String[] args) {
		sol();

	}

}
