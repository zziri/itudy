package priorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue priorityQueue = new PriorityQueue(100); // size 100�� �켱���� ť ����
		
		int[] test = {4,9,13,34,22,76,11,23};
		
		int[] result = priorityQueue.heapSort(test, 8);
		
		for(int i=0; i<8; i++)
			System.out.println(result[i]);
	}

}
