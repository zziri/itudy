package binarySearch.ex3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void sol()
	{
		Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // �� ����
        int m = sc.nextInt(); // ��û �� ����

        // �� ���� ���� ���� ���� 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ���� ���� ������� ���� Ž���� ���� �������� ���� ����
        int start = 0;
        int end = (int) 1e9; // ���� �ִ� ��: 1,000,000,000
        
        int result = 0; 
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            
            // ���� Ž������ ������ ���� ������ ©������ ���� ���� ���� ���ϱ�
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) 
                	total += arr[i] - mid; 
            }
      
            if (total < m) // ���� ���� ���� ������ ��� ���ܱ� ���� ���� �� ���� �ڸ���(���� �κ� Ž��)  
                end = mid - 1;
            else // ���� ���� ����� ��� ���ܱ� ���� ���� �� �ڸ���(������ �κ� Ž��)
            { 
                result = mid; // �ִ��� �� �߶��� ���� �����̹Ƿ�, ���⿡�� result�� ��� 
                start = mid + 1;
            }
        }

        System.out.println(result);
	}
	
	public static void main(String[] args) {
		sol();

	}

}
