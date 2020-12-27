package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTest {
	public static GraphByList graph; // 인접리스트 그래프	
	public static boolean checked[]; // 방문 노드 체크 배열
	
	public static void init(int size)
	{
		graph = new GraphByList(size);
		checked = new boolean[size+1];
	}
	
	public static void BFS(int node) // 시작노드 
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		int num;
		
		checked[node] = true; // 시작 노드 방문
		queue.add(node); // 시작 노드 enqueue
		
		while(!queue.isEmpty())
		{
			num = queue.poll();
			System.out.printf("%d ", num); // 출력
			
			for(int i=0; i<graph.getNode(num).size(); i++)
			{
				int next = graph.getNode(num).get(i);
				if(checked[next] == false) // 방문하지 않았다면
				{
					checked[next] = true; // 해당 노드 방문 체크
					queue.add(next); // 큐에 enqueue
				}
					
			}
		}
	}
	
	public static void main(String[] args)
	{
		init(5); // 노드의 갯수가 5인 그래프 초기화
		
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(2, 4);
		graph.insertEdge(3, 4);
		graph.insertEdge(3, 5);
		graph.insertEdge(4, 5);
				
		BFS(2);	
		
	}
}
