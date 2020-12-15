package graph;

class GraphByMaxtrix {
	private int[][] adj_matrix;
	
	public GraphByMaxtrix(int initSize)
	{
		// 배열의 인덱스는 0부터 시작하므로 편의성을 위해 1씩 크게 할당
		adj_matrix = new int[initSize + 1][initSize + 1];
	}
	
	// To do: 차수(인덱스범위) 벗어났을때 throw하게 구현
	// 무방향 그래프 간선 추가
	public void insertEdge(int start, int end)
	{
		adj_matrix[start][end] = adj_matrix[end][start] = 1;
	}
	
	// 가중치 있는 무방향 그래프 간선 추가
	public void insertEdgeWeight(int start, int end, int weight)
	{
		adj_matrix[start][end] = adj_matrix[end][start] = weight;
	}
	
	// 방향 그래프 간선 추가
	public void insertEdgeSingle(int start, int end)
	{
		adj_matrix[start][end] =1;
	}
	
	// 가중치 있는 방향 그래프 간선 추가
	public void insertEdgeSingleWeight(int start, int end, int weight)
	{
		adj_matrix[start][end] =weight;
	}
	
	public void displayAdjMaxtrix()
	{
		for(int node=1; node < adj_matrix.length; node++)
		{
			for(int adjNode=1; adjNode < adj_matrix[node].length; adjNode++)
			{
				System.out.printf("%d ",adj_matrix[node][adjNode]);
			}
			
			System.out.println("");
			
		}
			
	}
}

public class GraphByMaxtrixTest{
	public static void main(String[] args) {
		GraphByMaxtrix adjMat = new GraphByMaxtrix(6);
		
		adjMat.insertEdge(1, 2);
		adjMat.insertEdge(1, 3);
		adjMat.insertEdge(2, 3);
		adjMat.insertEdge(2, 4);
		adjMat.insertEdge(3, 4);
		adjMat.insertEdge(3, 5);
		adjMat.insertEdge(4, 5);
		adjMat.insertEdge(4, 6);
		
		adjMat.displayAdjMaxtrix();
	}
}
