package sort.ex4;

import java.util.*;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		int K = sc.nextInt();
		
		Integer[] arr1 = new Integer[cnt];
		Integer[] arr2 = new Integer[cnt];
		
		for(int i=0; i<cnt; i++)
			arr1[i] = sc.nextInt();
		for(int i=0; i<cnt; i++)
			arr2[i] = sc.nextInt();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		
		int i=0;
		while(K > 0) // �ٲܼ� �ִ� Ƚ������
		{
			if(arr1[i] <= arr2[i]) 
			{
				arr1[i] = arr2[i];
				i++;
				K--;
			}
			else // �ش� ���ǹ� ������ ��Ҵ� arr1�� ��Ұ� arr2 ��Һ��� �� ŭ 
				break;
				
		}
		
		int total = 0;
		for(int num : arr1)
			total += num;
		
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		sol();
	}

}
