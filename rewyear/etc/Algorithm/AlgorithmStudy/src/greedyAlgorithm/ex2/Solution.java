package greedyAlgorithm.ex2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // �Է� ���� ũ��
		int M = sc.nextInt(); // ���� Ƚ��
		int K = sc.nextInt(); // ���� �ε��� �������� �ִ� K������ ����
		int sum = 0;
		
		int[] arr = new int[N];
				
		for(int i=0; i<N; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int series = K;
		while(M != 0) {
			if(series != 0)// ���� ū���� series�� ���ϰ� series�� Ƚ�� �ٻ�������� 
			{
				sum += arr[N-1];
				series--;
			}
			else // �������� ū�� �ѹ� �����ش��� series reset; 
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
		
		int N = sc.nextInt(); // �Է� ���� ũ��
		int M = sc.nextInt(); // ���� Ƚ��
		int K = sc.nextInt(); // ���� �ε��� �������� �ִ� K������ ����
		int sum = 0;
		
		int[] arr = new int[N];
				
		for(int i=0; i<N; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		// ���� ū ���� �� �������� ū ���� �̷���� �ݺ����� ������ Ư¡�� ������ ����
		// ex) M = 8, K = 3�̰�, ���� ū ���� 6 �� ���� ū ���� 5�� ��
		// 6 6 6 5    6 6 6 5 ������ �ݺ����� ����
		int cnt = M/(K+1)*K; // ���� ū ���� ������ Ƚ��
		cnt += M % (K+1); // ������ �������� ���� ��� ������ ��ŭ ���� ū ���� ������ 
		
		sum += arr[N-1] * cnt;
		sum += arr[N-2] * (M-cnt);
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		sol2();
	}

}
