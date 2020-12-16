package graph;

public class DFSTest {
	public static GraphByMaxtrix graph; // ������� �׷���
	public static boolean checked[]; // �湮 ��� üũ �迭
	
	public static void init(int size)
	{
		graph = new GraphByMaxtrix(size);
		checked = new boolean[size+1];
	}
	
	public static void DFS(int node){
		checked[node] = true; // �湮
		System.out.printf("%d ", node); // ���
		
		for(int i=1; i<=graph.getDegree(); i++) // �ش� node�� �������� �湮
		{
			// node -> i ������ �־�� �ϸ�, �湮���� �������̶��
			if(graph.getNode(node)[i] == 1 && checked[i] == false)   
			{
				DFS(i);
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
		
		graph.displayAdjMaxtrix();
		
		DFS(2);	
	}
	
	
}
