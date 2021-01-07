package binarySearch.ex2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static String binarySearch(int[] list, int target, int start, int end)
	{
		if(start > end) return "no"; 
		int mid = (start+end)/2;
		
		if(target == list[mid])
			return "yes";
		else if(target < list[mid])
			return binarySearch(list, target, start, mid-1);
		else
			return binarySearch(list, target, mid+1, end);
		
	}
	// 이진 탐색을 이용한 풀이
	public static void sol1() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] itemList =new int[N];
		for(int i=0; i<N; i++) {
			itemList[i] = sc.nextInt();
		}
		
		Arrays.sort(itemList);
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			System.out.printf("%s ", binarySearch(itemList, sc.nextInt(), 0, N-1));
		}
	}
	
	// 계수 정렬 활용한 풀이
	public static void sol2() {
		int[] itemList = new int[1000001];
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			itemList[sc.nextInt()]++;
		}
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++)
		{
			if(itemList[sc.nextInt()] > 0)
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
	}
	
	// 중복을 허용하지 않는 set의 특성을 이용한 풀이
	public static void sol3() {
		HashSet<Integer> itemSet = new HashSet<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			itemSet.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++)
		{
			if(itemSet.contains(sc.nextInt()))
				System.out.print("yes ");
			else
				System.out.print("no ");
		}
		
		
	}
	public static void main(String[] args) {
		sol3();

	}

}
