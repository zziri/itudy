package dfs_bfs.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static int [][] map = new int[1000][1000];
	public static boolean[][] checked = new boolean[1000][1000];
	public static int rows,column;

	// 상, 하, 좌, 우
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	
	public static void dfs(int r, int c) {
		checked[r][c]=true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			
			// out of range
			if(nr < 0 || nr >= rows || nc < 0 || nc >= column)
				continue;
			
			if(map[nr][nc] == 0 && checked[nr][nc] == false)
			{
				dfs(nr,nc);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		rows=sc.nextInt();
		column=sc.nextInt();
		
		for(int i=0; i<rows; i++) {
			String line = sc.next();
			for(int j=0; j<column; j++) 
			{
				map[i][j] = line.charAt(j) - '0';
			}
			
		}
		
		int cnt = 0;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<column; j++) {
				// 뚫려있는 곳이며, 방문한적이 없는 경우 dfs를 통해 탐색
				if(map[i][j] == 0 && checked[i][j] == false) {
					dfs(i,j);
					cnt++;
				}
					
			}
		}
		System.out.println(cnt);
	}

}
