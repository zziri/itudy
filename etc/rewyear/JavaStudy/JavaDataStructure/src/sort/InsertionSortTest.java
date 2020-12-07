package sort;

class InsertionSort {
	public static void insertionSort(int[] list, int n)
	{
		for(int i=1; i<n; i++)
		{
			int key = list[i];
			int j;
			for(j=i-1; j>=0 && key<list[j]; j--) 
			{
				list[j+1] = list[j]; 
			}
			list[j+1] = key;			
		}
	}
}

public class InsertionSortTest {

	public static void main(String[] args) {
		int[] test = {4,9,13,34,22,76,11,23};
		
		InsertionSort.insertionSort(test, 8);
		
		for(int i=0; i<8; i++)
			System.out.println(test[i]);

	}

}
