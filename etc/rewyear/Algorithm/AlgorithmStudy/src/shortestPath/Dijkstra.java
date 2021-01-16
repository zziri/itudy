package shortestPath;

import java.util.*;

public class Dijkstra {	
	public static final int INF = (int)1e9; // ���� �� ����
	
	public static int n,m,start;
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // �׷��� ������ ��� �迭
	public static boolean[] visited = new boolean[100001]; // �湮 üũ ������ �迭
	public static int[] d = new int[100001]; // �ִܰŸ� ���̺�
	
	public static int getSmallestNode() {
		int minValue = INF;
		int idx = 0;
		for(int i=1; i<= n; i++)
		{
			if(d[i] < minValue && !visited[i]) {
				minValue = d[i];
				idx = i;
			}
		}
		
		return idx;
	}
	
	public static void dijkstra(int start) {
		// ������ �ʱ�ȭ
		d[start] = 0;
		visited[start] = true;
		
		// ���������� ���� �ִ� �Ÿ� ���̺� �ʱ�ȭ
		for(int j=0; j<graph.get(start).size(); j++)
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		
		// ���� ��带 ������ n-1���� ��忡 ���Ͽ� �ش� �˰��� �ݺ�
		for(int i=0; i<n-1; i++) 
		{
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j=0; j<graph.get(now).size(); j++)
			{
				// ���� �������� j������ ���µ� ���
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				// 
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // ��� ����
        m = sc.nextInt(); // ���� ����
        start = sc.nextInt(); // ������
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i=0; i<m; i++)
        {
        	int from = sc.nextInt();
        	int to = sc.nextInt();
        	int weight = sc.nextInt();
        	
        	graph.get(from).add(new Node(to, weight));
        }
        
        Arrays.fill(d, INF);
        
        dijkstra(start);
        
        for(int i=1; i<= n; i++) {
        	if(d[i] == INF)
        		System.out.println("INFINITY");
        	else
        		System.out.println(d[i]);
        		
        }

	}

}
