package sort;
import utils.Util;

class SelectionSort{
	public static void selectionSort (int[] list, int n)
	{
		for(int i=0; i<n-1; i++)
		{
			// 가장 작은 요소의 인덱스 찾기
			int minIdx = i;
			for(int j=i+1; j<n; j++) 
			{
				if(list[minIdx] > list[j])
					minIdx = j;
			}
			Util.swap(list, i, minIdx); // Swap
			
		}
	}
}

public class SelectionSortTest {

	public static void main(String[] args) {
		int[] test = {4,9,13,34,22,76,11,23};
		
		SelectionSort.selectionSort(test, 8);
		
		for(int i=0; i<8; i++)
			System.out.println(test[i]);

	}

}


