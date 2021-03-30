package sort.ex2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void sol()
	{
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		Integer[] arr = new Integer[cnt];
		
		for(int i=0; i<cnt; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr,Collections.reverseOrder());
				
		for(int data : arr) {
			System.out.printf("%d ", data);
		}
	}
	public static void main(String[] args) {
		sol();
	}

}
