package greedyAlgorithm.ex2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 입력 받을 크기
		int M = sc.nextInt(); // 덧셈 횟수
		int K = sc.nextInt(); // 같은 인덱스 연속으로 최대 K번까지 덧셈
		int sum = 0;
		
		int[] arr = new int[N];
				
		for(int i=0; i<N; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int series = K;
		while(M != 0) {
			if(series != 0)// 가장 큰수를 series번 더하고 series번 횟수 다사용했으면 
			{
				sum += arr[N-1];
				series--;
			}
			else // 다음으로 큰수 한번 더해준다음 series reset; 
			{
				sum += arr[N-2];
				series=K; 
			}
			M--;
			
		}
		System.out.println(sum);
	}
	
	public static void sol2() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 입력 받을 크기
		int M = sc.nextInt(); // 덧셈 횟수
		int K = sc.nextInt(); // 같은 인덱스 연속으로 최대 K번까지 덧셈
		int sum = 0;
		
		int[] arr = new int[N];
				
		for(int i=0; i<N; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		// 가장 큰 수와 그 다음으로 큰 수로 이루어진 반복적인 수열의 특징을 가지고 있음
		// ex) M = 8, K = 3이고, 가장 큰 수가 6 그 다음 큰 수가 5일 때
		// 6 6 6 5    6 6 6 5 형태의 반복적인 수열
		int cnt = M/(K+1)*K; // 가장 큰 수가 더해질 횟수
		cnt += M % (K+1); // 나누어 떨어지지 않을 경우 나머지 만큼 가장 큰 수를 더해줌 
		
		sum += arr[N-1] * cnt;
		sum += arr[N-2] * (M-cnt);
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		sol2();
	}

}
