package graph;

class GraphByMaxtrix {
	private int[][] adj_matrix;
	
	public GraphByMaxtrix(int initSize)
	{
		// �迭�� �ε����� 0���� �����ϹǷ� ���Ǽ��� ���� 1�� ũ�� �Ҵ�
		adj_matrix = new int[initSize + 1][initSize + 1];
	}
	
	// To do: ����(�ε�������) ������� throw�ϰ� ����
	// ������ �׷��� ���� �߰�
	public void insertEdge(int start, int end)
	{
		adj_matrix[start][end] = adj_matrix[end][start] = 1;
	}
	
	// ����ġ �ִ� ������ �׷��� ���� �߰�
	public void insertEdgeWeight(int start, int end, int weight)
	{
		adj_matrix[start][end] = adj_matrix[end][start] = weight;
	}
	
	// ���� �׷��� ���� �߰�
	public void insertEdgeSingle(int start, int end)
	{
		adj_matrix[start][end] =1;
	}
	
	// ����ġ �ִ� ���� �׷��� ���� �߰�
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
