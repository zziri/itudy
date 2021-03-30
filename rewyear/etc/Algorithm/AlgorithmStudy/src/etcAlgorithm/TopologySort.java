package etcAlgorithm;

import java.util.*;

public class TopologySort {
	public static int n,e; 
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	public static int[] inDgr; 
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 진입차수가 0인 노드는 result 배열에 삽입
		for(int i=1; i<= n; i++) {
			if(inDgr[i] == 0) 
				q.offer(i);
		}
		
		// 큐가 빌 때까지
		while(!q.isEmpty()) 
		{
			int now = q.poll();
			result.add(now);
			
			for(int i=0; i<graph.get(now).size(); i++) 
			{
				int d = graph.get(now).get(i);
				inDgr[d]--;
				if(inDgr[d]==0)
					q.offer(d);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 노드 개수
		e = sc.nextInt(); // 간선 개수
		
		for(int i=0; i<=n; i++) // 그래프 초기화
			graph.add(new ArrayList<Integer>());
		
		inDgr = new int[n+1]; // 진입차수 배열 초기화

		// 간선 정보 입력, to로 입력되는 노드는 진입차수가 1증가
		int from,to;
		for(int i=0; i<e; i++) 
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			graph.get(from).add(to);
			inDgr[to]++;
		}
		
		// 위상정렬
		topologySort();
		
		for(int i:result)
			System.out.printf("%d ", i);
		
	}

}
