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
		Util.swap(list, left, mid); // ��� ��Ҹ� pivot���� ������ �� ������ �̵�
		
		int low = left, high = right;
	
		while(low < high)
		{
			// pivot ���� ū ��Ҹ� ã���� ���� R2L
			while(low < high && list[high] > pivot) 
				high--;
			
			// pivot ���� ���� ��Ҹ� ã���� ���� L2R�ϰų� low,high�� �����ϴ� ��� 
			while(low < high && list[low] <= pivot) 
				low++;
			
			Util.swap(list,low,high);
		}
		
		// �� �̻� ���� ������ �����ϸ鼭 swap�� ��ҵ��� ���� ��� ���ο� �ǹ��� ����
		list[left] = list[low]; 
		
		// ���� �ǹ��� �ش� ��ġ�� ����. �� ��� �������� ��,�� �迭�� �����ؼ� �ٽ� ����Ʈ ����
		// �̶� �� ����Ʈ�� ��ҵ��� pivot�� ���� �۰�, �� ����Ʈ ��ҵ��� pivot���� ū ��ҵ��̴�.
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
