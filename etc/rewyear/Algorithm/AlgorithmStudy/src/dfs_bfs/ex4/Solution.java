package dfs_bfs.ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static class Pair{
		public int r;
		public int c;
		
		public Pair(int r, int c)
		{
			this.r = r;
			this.c = c;
		}
	}
	
	public static int[][] map = new int[200][200];
	public static int[][] checked = new int[200][200];
	public static int rows, column;
	
	// ��, ��, ��, ��
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		rows = sc.nextInt();
		column = sc.nextInt();
		
		for(int i=0; i<rows; i++) {
			String line = sc.next();
			for(int j=0; j<column; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		
		Queue<Pair> queue = new LinkedList<Pair>();
		
		// ������
		queue.offer(new Pair(0,0));
		checked[0][0] = 1;
		
		while(!queue.isEmpty())
		{
			Pair node = queue.poll();
			
			// �ⱸ�� ������ ���
			if(node.r == rows && node.c == column)
				break;
			
			int nr, nc;
			for(int i=0; i<4; i++)
			{
				nr = node.r + dy[i];
				nc = node.c + dx[i];
				
				// out of range
				if(nr < 0 || nr >= rows || nc < 0 || nc >= column)
					continue;
				
				// ���� �ִ� ���̸�, �湮�� ���� ���� ��� 
				if(map[nr][nc] == 1 && checked[nr][nc] == 0) {
					queue.offer(new Pair(nr,nc));
					
					// ���� ��忡 ���� ��ĭ �� �̵��� ���̹Ƿ� +1
					checked[nr][nc] = checked[node.r][node.c] + 1;
				}
			}
		}
		
		System.out.println(checked[rows-1][column-1]);
	}

}
