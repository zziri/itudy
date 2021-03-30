package shortestPath.ex2;

import java.util.*;

public class Solution {
	public static final int INF = (int)1e9;
	public static int n,m;
	public static int k,x;
	public static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 노드 개수
		m = sc.nextInt(); // 간선 개수
		
		// INF로 초기화
		for(int i=1; i<=n; i++)
			Arrays.fill(graph[i], INF);
		
		// 자기자신노드 비용 초기화
		for(int i=1; i<=n; i++)
			graph[i][i] = 0;
		
		// 그래프 입력
		int from,to;
		for(int i=0; i<m; i++)
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		
		//  방문판매 지점X 및 소개팅지점 입력
		x=sc.nextInt();
		k=sc.nextInt();		
		
		// ab = ac + cb, Floyd Warshall 알고리즘의 핵심
		for(int c=1; c<=n; c++) {
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][c] + graph[c][b]);
				}
			}
		}
		
		
		int result = graph[1][k] + graph[k][x];
		
		if(result < INF)
			System.out.println(result);
		else
			System.out.println(-1);

	}

}
