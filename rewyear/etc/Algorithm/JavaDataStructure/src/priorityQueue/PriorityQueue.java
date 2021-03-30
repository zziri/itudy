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
		
		// 맨 마지막 노드에 새로운 데이터를 삽입하고 비교해 가면서 스왑하는 것보다
		// 삽입할 위치를 찾아가면서 부모노드를 이동하는것이 오버헤드가 적은 방식 
		while((currentIndex != 0) && (maxHeap[parentIndex] < data)){
			maxHeap[currentIndex] = maxHeap[parentIndex]; 
			currentIndex = parentIndex;
			parentIndex = (currentIndex-1)/2;
			
		}
		maxHeap[currentIndex] = data; // 마지막 노드에 삽입
		count++;
	}
	
	public int deleteHeap()
	{
		int item = maxHeap[0]; // root 노드 값
		int tmp = maxHeap[count-1]; // 마지막 노드 값
		
		int currentIndex = 0; // root부터 시작
		int childIndex = (2*currentIndex) + 1; // 왼쪽 자식노드
		
		
		while(childIndex < count) {
			// 현재 부모노드의 값이 오,왼 자식노드보다 작은경우
			if(tmp < maxHeap[childIndex] || tmp < maxHeap[childIndex+1])
			{
				// 자식노드들 중에서 큰 값과 스왑
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
