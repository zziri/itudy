package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	public static GraphByList graph; // ��������Ʈ �׷���	
	public static boolean checked[]; // �湮 ��� üũ �迭
	
	public static void init(int size)
	{
		graph = new GraphByList(size);
		checked = new boolean[size+1];
	}
	
	public static void BFS(int node) // ���۳�� 
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		int num;
		
		checked[node] = true; // ���� ��� �湮
		queue.add(node); // ���� ��� enqueue
		
		while(!queue.isEmpty())
		{
			num = queue.poll();
			System.out.printf("%d ", num); // ���
			
			for(int i=0; i<graph.getNode(num).size(); i++)
			{
				int next = graph.getNode(num).get(i);
				if(checked[next] == false) // �湮���� �ʾҴٸ�
				{
					checked[next] = true; // �ش� ��� �湮 üũ
					queue.add(next); // ť�� enqueue
				}
					
			}
		}
	}
	
	public static void main(String[] args)
	{
		init(5); // ����� ������ 5�� �׷��� �ʱ�ȭ
		
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(2, 4);
		graph.insertEdge(3, 4);
		graph.insertEdge(3, 5);
		graph.insertEdge(4, 5);
				
		BFS(2);	
		
	}
}
