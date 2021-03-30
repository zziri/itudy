package shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd_warshall {
	public static final int INF = (int)1e9; // 무한 값 설정
	
	public static int n,m; // 노드 갯수, 간선개수;
	
	public static int[][] map = new int[501][501]; // 최대 노드 갯수 500로 가정
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수
        
        for(int i=1; i<=n; i++) {
        	Arrays.fill(map[i], INF);
        }
        
        // 자기 자신에서 자기자신으로 가는 비용 0으로 초기화
        for(int i=1; i<=n; i++) {
        	map[i][i] = 0;
        }       
        
        // 간선 입력
        int from,to,weight;
        for(int i=0; i<m; i++)
        {
        	from = sc.nextInt();
        	to = sc.nextInt();
        	weight = sc.nextInt();
        	map[from][to] = weight;
        }
        
        // ab = ac + cb
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		for(int k=1; k<=n; k++) {
        			map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
        		}
        	}
        }
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(map[i][j] == INF)
        			System.out.print("INF ");
        		else
        			System.out.printf("%d ",map[i][j]);
        	}
        	System.out.println("");
        }

	}

}
