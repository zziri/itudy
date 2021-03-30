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
		else if(target < list[mid]) // ã�� ���� �߰������ ������ ���� ���
			return binarySearch(list,target,start,mid-1);
		else // ã�� ���� �߰������ ������ ū ���
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
		
		Arrays.sort(arr); // ���� Ž���� ���������� �迭 �� ����Ʈ�� ���ĵǾ� �־�� �Ѵ�.
		int idx = BinarySearch.binarySearch(arr, target, 0, n-1);
		
		if(idx < 0)
			System.out.println("No exist in array");
		else
			System.out.println(idx);
			
	}

}
