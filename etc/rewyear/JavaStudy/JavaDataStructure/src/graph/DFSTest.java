package graph;

public class DFSTest {
	public static GraphByMaxtrix graph; // 인접행렬 그래프
	public static boolean checked[]; // 방문 노드 체크 배열
	
	public static void init(int size)
	{
		graph = new GraphByMaxtrix(size);
		checked = new boolean[size+1];
	}
	
	public static void DFS(int node){
		checked[node] = true; // 방문
		System.out.printf("%d ", node); // 출력
		
		for(int i=1; i<=graph.getDegree(); i++) // 해당 node의 인접정점 방문
		{
			// node -> i 간선이 있어야 하며, 방문하지 않은곳이라면
			if(graph.getNode(node)[i] == 1 && checked[i] == false)   
			{
				DFS(i);
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
		
		graph.displayAdjMaxtrix();
		
		DFS(2);	
	}
	
	
}
