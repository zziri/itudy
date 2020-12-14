package sort;

import utils.Util;

class QuickSort{
	public static void quickSort(int[] list, int left, int right)
	{
		if(left >= right)
			return;
		
		int pivot = partition(list, left, right);
		quickSort(list, left, pivot - 1);
		quickSort(list, pivot + 1, right);	
	}
	
	public static int partition(int[] list, int left, int right)
	{
		int mid = (left + right) / 2;
		int pivot = list[mid];
		Util.swap(list, left, mid); // 가운데 요소를 pivot으로 선택해 맨 앞으로 이동
		
		int low = left, high = right;
	
		while(low < high)
		{
			// pivot 보다 큰 요소를 찾을때 까지 R2L
			while(low < high && list[high] > pivot) 
				high--;
			
			// pivot 보다 작은 요소를 찾을때 까지 L2R하거나 low,high가 교차하는 경우 
			while(low < high && list[low] <= pivot) 
				low++;
			
			Util.swap(list,low,high);
		}
		
		// 더 이상 위의 조건을 만족하면서 swap할 요소들이 없는 경우 새로운 피벗을 선정
		list[left] = list[low]; 
		
		// 기존 피벗을 해당 위치에 삽입. 이 요소 기준으로 앞,뒤 배열을 분할해서 다시 퀵소트 진행
		// 이때 앞 리스트의 요소들은 pivot의 보다 작고, 뒤 리스트 요소들은 pivot보다 큰 요소들이다.
		list[low] = pivot; 
		
		return low;
		
	}
}

public class QuickSortTest {

	public static void main(String[] args) {
		int[] test = {4,34,13,2,22,76,11,23};
		
		QuickSort.quickSort(test, 0, test.length - 1);
		
		for(int i=0; i<test.length; i++)
			System.out.println(test[i]);

	}

}
