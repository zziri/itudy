package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Util {
	public static void swap(int[] list, int idx1, int idx2)
	{
		int tmp;
		
		tmp = list[idx1];
		list[idx1] = list[idx2];
		list[idx2] = tmp;
	}
}

class SelectionSort{
	public static void selectionSort(int[] list, int cnt)
	{
		for(int i=0; i<cnt-1; i++)
		{
			int min = i; 
			for(int j=i+1; j<cnt; j++)
			{
				if(list[j] < list[min])
					min=j;
			}
			Util.swap(list, i, min);
		}
	}
}

class InsertionSort{
	public static void insertionSort(int[] list, int cnt)
	{
		
		for(int i=1; i<cnt; i++)
		{
			int key = list[i];
			int j;
			for(j=i-1; j>=0 && list[j] > key; j--)
			{
				list[j+1] = list[j];
			}
			list[j+1] = key;
		}
	}
}

class QuickSort{
	public static void quickSort(int[] list, int left, int right)
	{
		if(left >= right)
			return;
		
		int pivot = partition(list,left,right);
		quickSort(list,left,pivot-1);
		quickSort(list,pivot+1,right);
	}
	
	public static int partition(int[] list, int left, int right)
	{
		int mid = (left + right)/2;
		int pivot = list[mid];
		Util.swap(list, left, mid);
		
		int low = left, high = right;
		
		while(low < high)
		{
			while(low < high && list[high] > pivot)
				high--;
			
			while(low < high && list[low] <= pivot)
				low++;

			Util.swap(list,low,high);
		}
		
		list[left] = list[low];
		
		list[low] = pivot; 
		
		return low;
	}
	
}

class CountSort{
	public static void countSort(int[] list, int max) {
		int[] count = new int[max+1];
		
		for(int i : list) {
			count[i]++;
		}
		
		int i=0, idx=0;
		while(i<list.length)
		{
			if(count[idx] != 0) {
				list[i++]=idx;
				count[idx]--;
			}
			else
				idx++;
		}
		
	}
}

public class SortTest {

	public static void main(String[] args) {
		int list[] = {7,-2,4,11,3,51,34,22};
		int listForCntSort[] = {7, 5, 9, 0, 3, 1, 6, 
				2, 9, 1, 4, 8, 0, 5, 2};
//		SelectionSort.selectionSort(list, list.length);
//		InsertionSort.insertionSort(list, list.length);
		QuickSort.quickSort(list, 0, list.length-1);
		for(int i:list)
		{
			System.out.printf("%d ",i);
		}
		System.out.println("");
		
		CountSort.countSort(listForCntSort, 9);
		for(int i:listForCntSort)
		{
			System.out.printf("%d ",i);
		}
		System.out.println("");
		
		// Java에서 array에 대한 sort는 Arrays.sort()메서드를
		int arrForJava[] = {7,-2,4,11,3,51,34,22,
				17, -5, 9, 40, 3, 112, 6};
		
		// collection에 대한 sort는 Collections.sort()메서드를 사용하면 된다.
		ArrayList<Integer> listForJava = new ArrayList<Integer>();
		for(int i:arrForJava) {
			listForJava.add(i);
		}
		
		// array정렬 예시
		Arrays.sort(arrForJava);
		for(int i:arrForJava)
		{
			System.out.printf("%d ",i);
		}
		System.out.println("");
		
		// ArrayList(collection)정렬 예시
		Collections.sort(listForJava);
		for(int i:listForJava)
		{
			System.out.printf("%d ",i);
		}
	}

}
