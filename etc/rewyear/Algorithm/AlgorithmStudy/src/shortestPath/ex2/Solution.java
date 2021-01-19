package shortestPath.ex2;

import java.util.*;

public class Solution {
	public static final int INF = (int)1e9;
	public static int n,m;
	public static int k,x;
	public static int[][] graph = new int[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // ��� ����
		m = sc.nextInt(); // ���� ����
		
		// INF�� �ʱ�ȭ
		for(int i=1; i<=n; i++)
			Arrays.fill(graph[i], INF);
		
		// �ڱ��ڽų�� ��� �ʱ�ȭ
		for(int i=1; i<=n; i++)
			graph[i][i] = 0;
		
		// �׷��� �Է�
		int from,to;
		for(int i=0; i<m; i++)
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
		
		//  �湮�Ǹ� ����X �� �Ұ������� �Է�
		x=sc.nextInt();
		k=sc.nextInt();		
		
		// ab = ac + cb, Floyd Warshall �˰����� �ٽ�
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
