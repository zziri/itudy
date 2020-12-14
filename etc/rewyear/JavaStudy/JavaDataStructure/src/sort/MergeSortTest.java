package sort;

class MergeSort{
	public static int[] sorted = new int[1000];
	
	public static void mergeSort(int[] list, int left, int right)
	{
		if(left < right)
		{
			int mid = (left + right) / 2;
			
			// 중간 요소를 기점으로 array를 분할
			mergeSort(list, left, mid);
			mergeSort(list, mid + 1, right);
			
			// 어느 기준 이상 분할되었다하면 다시 merge하면서 정렬 진행
			merge(list, left, mid, right);
		}
	}
	
	public static void merge(int[] list, int left, int mid, int right)
	{
		int lidx = left, ridx = mid + 1;
		int pos = left;
		
		// 분할한 두 배열을 순차적으로 비교하면서 merge
		while(lidx <= mid && ridx <= right)
		{
			if(list[lidx] <= list[ridx])
				sorted[pos++] = list[lidx++];
			else
				sorted[pos++] = list[ridx++];
		}
		
		// 남은 요소들을 copy
		while(lidx <= mid)
			sorted[pos++] = list[lidx++];
		while(ridx <= right)
			sorted[pos++] = list[ridx++];
		
		// sorting된 임시 저장 array를 원래 배열에 copy 
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
