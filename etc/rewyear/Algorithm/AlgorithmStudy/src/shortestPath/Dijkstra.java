package shortestPath;

import java.util.*;

public class Dijkstra {	
	public static final int INF = (int)1e9; // 무한 값 설정
	
	public static int n,m,start;
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>(); // 그래프 정보를 담는 배열
	public static boolean[] visited = new boolean[100001]; // 방문 체크 목적의 배열
	public static int[] d = new int[100001]; // 최단거리 테이블
	
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
		// 시작점 초기화
		d[start] = 0;
		visited[start] = true;
		
		// 시작점에서 부터 최단 거리 테이블 초기화
		for(int j=0; j<graph.get(start).size(); j++)
			d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
		
		// 시작 노드를 제외한 n-1개의 노드에 대하여 해당 알고리즘 반복
		for(int i=0; i<n-1; i++) 
		{
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j=0; j<graph.get(now).size(); j++)
			{
				// 현재 지점에서 j노드까지 가는데 비용
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
