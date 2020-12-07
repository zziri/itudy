package priorityQueue;
import utils.Util;

public class PriorityQueue {
	private int count;
	private int[] maxHeap;
	
	public PriorityQueue(int size) {
		this.count = 0;
		this.maxHeap = new int[size];
	}
	
	public void insertHeap(int data)
	{
		int parentIndex = (count-1)/2;
		int currentIndex = count;
		
		// �� ������ ��忡 ���ο� �����͸� �����ϰ� ���� ���鼭 �����ϴ� �ͺ���
		// ������ ��ġ�� ã�ư��鼭 �θ��带 �̵��ϴ°��� ������尡 ���� ��� 
		while((currentIndex != 0) && (maxHeap[parentIndex] < data)){
			maxHeap[currentIndex] = maxHeap[parentIndex]; 
			currentIndex = parentIndex;
			parentIndex = (currentIndex-1)/2;
			
		}
		maxHeap[currentIndex] = data; // ������ ��忡 ����
		count++;
	}
	
	public int deleteHeap()
	{
		int item = maxHeap[0]; // root ��� ��
		int tmp = maxHeap[count-1]; // ������ ��� ��
		
		int currentIndex = 0; // root���� ����
		int childIndex = (2*currentIndex) + 1; // ���� �ڽĳ��
		
		
		while(childIndex < count) {
			// ���� �θ����� ���� ��,�� �ڽĳ�庸�� �������
			if(tmp < maxHeap[childIndex] || tmp < maxHeap[childIndex+1])
			{
				// �ڽĳ��� �߿��� ū ���� ����
				if(maxHeap[childIndex] >= maxHeap[childIndex + 1])
				{
					maxHeap[currentIndex] = maxHeap[childIndex];
					currentIndex = childIndex;
					
				}
				else
				{
					maxHeap[currentIndex] = maxHeap[childIndex + 1];
					currentIndex = childIndex+1;
				}
				childIndex = (2*currentIndex) + 1;
				
			}
			else 
				break;
		}
		
		maxHeap[currentIndex] = tmp; 
		count--;
		return item;
	}
	
	public boolean isEmpty() {
		return count == 0 ? true:false;
	}
	
	public int[] heapSort(int[] arr, int size)
	{
		int[] sorted = new int[size];
		
		for(int i=0; i<size; i++)
			insertHeap(arr[i]);
		
		for(int i=0; i<size; i++)
			sorted[i] = deleteHeap();
		
		return sorted;
	}
}
