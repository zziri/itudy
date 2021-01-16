package shortestPath;

import java.util.*;

public class AdvancedDijkstra {
	public static final int INF = (int)1e9;
	
	public static int n,m,start;
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[1000001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start,0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i=0; i < graph.get(now).size(); i++)
			{
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
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
