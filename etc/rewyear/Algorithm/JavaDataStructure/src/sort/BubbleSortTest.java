package sort;
import utils.Util;

class BubbleSort {
	public static void bubbleSort(int[] list, int n)
	{
		int i,j;
		
		for(i=n; i>0; i--) 
		{
			for(j=0; j<i-1; j++)
			{
				if(list[j] > list[j+1])
					Util.swap(list, j, j+1);
			}
		}
	}
}

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] test = {4,9,13,34,22,76,11,23};
		
		BubbleSort.bubbleSort(test, 8);
		
		for(int i=0; i<8; i++)
			System.out.println(test[i]);

	}

}
