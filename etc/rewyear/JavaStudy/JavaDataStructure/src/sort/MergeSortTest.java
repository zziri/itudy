package sort;

class MergeSort{
	public static int[] sorted = new int[1000];
	
	public static void mergeSort(int[] list, int left, int right)
	{
		if(left < right)
		{
			int mid = (left + right) / 2;
			
			// �߰� ��Ҹ� �������� array�� ����
			mergeSort(list, left, mid);
			mergeSort(list, mid + 1, right);
			
			// ��� ���� �̻� ���ҵǾ����ϸ� �ٽ� merge�ϸ鼭 ���� ����
			merge(list, left, mid, right);
		}
	}
	
	public static void merge(int[] list, int left, int mid, int right)
	{
		int lidx = left, ridx = mid + 1;
		int pos = left;
		
		// ������ �� �迭�� ���������� ���ϸ鼭 merge
		while(lidx <= mid && ridx <= right)
		{
			if(list[lidx] <= list[ridx])
				sorted[pos++] = list[lidx++];
			else
				sorted[pos++] = list[ridx++];
		}
		
		// ���� ��ҵ��� copy
		while(lidx <= mid)
			sorted[pos++] = list[lidx++];
		while(ridx <= right)
			sorted[pos++] = list[ridx++];
		
		// sorting�� �ӽ� ���� array�� ���� �迭�� copy 
		for(int i=left; i<=right; i++)
		{
			list[i] = sorted[i];
		}
	}
}

public class MergeSortTest {

	public static void main(String[] args) {
		int[] test = {4,34,13,2,22,76,11,23};
		
		MergeSort.mergeSort(test, 0, test.length - 1);
		
		for(int i=0; i<test.length; i++)
			System.out.println(test[i]);

	}

}
