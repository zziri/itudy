package shortestPath;

import java.util.*;

public class Dijkstra {	
	public static final int INF = (int)1e9; // 무한 값 설정
	
	public static int n,m,start; // 노드갯수, 간선갯수, 시작점
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 그래프 정보를 담는 배열
	public static boolean[] visited = new boolean[100001]; // 방문 체크 목적의 배열
	public static int[] d = new int[100001]; // 최단거리 테이블
	
	public static int getSmallestNode() {
		int minValue = INF;
		int idx = 0;
		for(int i=1; i<= n; i++)
		{
			if(d[i] < minValue && !visited[i]) // 방문하지 않은 지점 중 현재 가장 짧은 거리를 가지고 있는 경우 
			{
				minValue = d[i];
				idx = i;
			}
		}
		
		return idx;
	}
	
	public static void dijkstra(int start) {
		// 시작점 초기화
		d[start] = 0;
		visited[start] = true;
		
		// 시작점에서부터 인접노드까지 최단 거리 테이블 초기화
		for(int j=0; j<graph.get(start).size(); j++)
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		
		// 각 스텝마다 최단거리의 노드를 찾아 해당 노드를 거쳐갈때의 비용을 구해서 최단거리 갱신
		for(int i=0; i<n-1; i++) 
		{
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j=0; j<graph.get(now).size(); j++)
			{
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				// 현재 지점(now)을 거쳐 i노드로 가는 비용이 적게 드는 경우 
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수
        start = sc.nextInt(); // 시작점
        
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
