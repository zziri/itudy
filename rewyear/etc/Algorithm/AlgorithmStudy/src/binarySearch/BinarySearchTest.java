package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

class BinarySearch{
	public static int binarySearch(int[] list, int target, int start, int end)
	{
		if (start > end) return -1;
		
		int mid = (start + end)/2;
		
		if(target == list[mid])
			return mid;
		else if(target < list[mid]) // 찾는 값이 중간요소의 값보다 작은 경우
			return binarySearch(list,target,start,mid-1);
		else // 찾는 값이 중간요소의 값보다 큰 경우
			return binarySearch(list,target,mid+1,end);
	}
}

public class BinarySearchTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int target = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
		{
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr); // 이진 탐색의 전제조건은 배열 및 리스트가 정렬되어 있어야 한다.
		int idx = BinarySearch.binarySearch(arr, target, 0, n-1);
		
		if(idx < 0)
			System.out.println("No exist in array");
		else
			System.out.println(idx);
			
	}

}
