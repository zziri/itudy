package shortestPath.ex3;

import java.util.*;

class Node implements Comparable<Node>{
	private int idx;
	private int distance;
	
	public Node(int idx, int distance)
	{
		this.idx = idx;
		this.distance = distance;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		return this.getDistance() - o.getDistance();
	}
	
	
}

public class Solution {
	public static final int INF = (int)1e9;
	public static int n,m,c;
	
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[30001];
	
	public static void advancedDijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		d[start] = 0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty())
		{
			Node node = pq.poll();
			
			int now = node.getIdx();
			int dis = node.getDistance();
			
			if(d[now] < dis) continue;
			
			for(int i=0; i<graph.get(now).size(); i++)
			{
				int cost = d[now] + graph.get(now).get(i).getDistance(); 
				
				if(cost < d[graph.get(now).get(i).getIdx()]) {
					d[graph.get(now).get(i).getIdx()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIdx(),cost));
				}
					
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();
		c=sc.nextInt();
		
		// graph 초기화
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<Node>());
		
		// graph 입력
		int from, to, weight;
		for(int i=0; i<m; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			weight = sc.nextInt();
			
			graph.get(from).add(new Node(to,weight));
		}
		
		// 최단거리 테이블 초기화
		Arrays.fill(d, INF);
		
		advancedDijkstra(c);
		
		int count=0, maxDistance=0;
		for(int i=1; i<= n; i++) {
        	if(d[i] != INF) {
        		count++;
        		
        		maxDistance = Math.max(maxDistance, d[i]);
        	}
        	
        }
		
		System.out.printf("%d %d",count-1, maxDistance);
			
			

	}

}
