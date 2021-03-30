package greedyAlgorithm.ex3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		
		int[][] matrix = new int[N][M];
		int [] firstColumn = new int[N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			Arrays.sort(matrix[i]);
		}
		
		for(int i=0; i<N; i++)	{
			firstColumn[i] = matrix[i][0];
		}
		
		Arrays.sort(firstColumn);
		
		System.out.println(firstColumn[N-1]);
	}
	
	public static void sol2() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 행
		int M = sc.nextInt(); // 열
		int result = 0;
		
		for(int i=0; i<N; i++) {
			int minValue = 10001;
			
			for(int j=0; j<M; j++) { // 한 라인 당 가장 작은 수 찾기
				int input = sc.nextInt();
				minValue = Math.min(minValue, input);
			}
			
			result = Math.max(result, minValue);
		}
	}
	
	public static void main(String[] args) {
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		sol1();
		endTime = System.currentTimeMillis();
		
		System.out.printf("duration: %d",endTime - startTime);

	}

}
