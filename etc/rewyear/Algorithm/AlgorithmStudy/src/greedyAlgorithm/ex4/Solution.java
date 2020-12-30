package greedyAlgorithm.ex4;

import java.util.Scanner;

public class Solution {
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		
		while(N != 1) // 1�� �ɶ�����
		{
			if(N%K != 0) { // K�� ������ ������ ������ -1 ����
				N--;
				cnt++;
			}
			else { // ������ �������� ��� K�� ������
				N /= K;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static void sol2() {
		 Scanner sc = new Scanner(System.in);

	        // N, K�� ������ �������� �����Ͽ� �Է� �ޱ�
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int result = 0;

	        while (true) {
	            // N�� K�� ������ �������� ���� �� �������� 1�� ����
	            int target = (n / k) * k;
	            result += (n - target);
	            n = target;
	            // N�� K���� ���� �� (�� �̻� ���� �� ���� ��) �ݺ��� Ż��
	            if (n < k) break;
	            // K�� ������
	            result += 1;
	            n /= k;
	        }

	        // ���������� ���� ���� ���Ͽ� 1�� ����
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
