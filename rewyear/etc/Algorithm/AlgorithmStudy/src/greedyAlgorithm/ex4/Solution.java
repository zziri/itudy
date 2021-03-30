package greedyAlgorithm.ex4;

import java.util.Scanner;

public class Solution {
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		
		while(N != 1) // 1이 될때까지
		{
			if(N%K != 0) { // K로 나누어 떨어질 때까지 -1 연산
				N--;
				cnt++;
			}
			else { // 나누어 떨어지는 경우 K로 나누기
				N /= K;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void sol2() {
		 Scanner sc = new Scanner(System.in);

	        // N, K를 공백을 기준으로 구분하여 입력 받기
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int result = 0;

	        while (true) {
	            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
	            int target = (n / k) * k;
	            result += (n - target);
	            n = target;
	            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
	            if (n < k) break;
	            // K로 나누기
	            result += 1;
	            n /= k;
	        }

	        // 마지막으로 남은 수에 대하여 1씩 빼기
	        result += (n - 1);
	        System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end;
		
		start = System.currentTimeMillis();
		sol1();
		end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}

}
