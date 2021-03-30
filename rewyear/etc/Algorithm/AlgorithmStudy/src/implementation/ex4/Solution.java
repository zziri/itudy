package implementation.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt(); // 행
		int c = sc.nextInt(); // 열
		
		int[][] map = new int[r][c];
		// 북:0, 동:1, 남:2, 서:3
		int dx[] = {0,1,0,-1};
		int dy[] = {-1,0,1,0};
		
		// 시작점과 시작 방향 설정
		int posX=sc.nextInt();
		int posY=sc.nextInt();
		int direction=sc.nextInt();
				
		// map 입력(0: 육지, 1: 바다, 2: 방문)
		for(int i=0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		
		// 시작점 방문했다고 처리
		int cnt=1;
		map[1][1] = 2; 
		
		// 탐색 시작
		while(true)
		{	
			int turn=0;
			
			// 방향 체크
			while(turn<4)
			{
				int nx = posX + dx[direction];
				int ny = posY + dy[direction];
				
				// 다음 방문할 곳이 바다이거나 방문한 곳인 경우
				if(map[ny][nx] == 1 || map[ny][nx] == 2)
				{
					direction = (direction+1)%4; // 방향 변경
					turn++;
				}
				else // 방문 가능할 곳인 경우
				{
					map[ny][nx] = 2; // 방문 체크
					posX = nx; // 이동
					posY = ny;
					cnt++; // 방문 칸수 +1
					break;
				}
			}
			
			// 네 방향 다 체크했는데도 갈 곳이 없는 경우, 뒷  길 체크
			// 육지면 백스텝, 바다라면 종료
			if(turn == 4) {
				int back = (direction+2)%4; 
				int bx = posX + dx[back];
				int by = posY + dy[back];
				
				if(map[by][bx] == 1) 
					break;
				else if(map[by][bx] == 2) {
					posX = bx; // 이동
					posY = by;
				}
			}
				
		}
		System.out.println(cnt);
	}

}
