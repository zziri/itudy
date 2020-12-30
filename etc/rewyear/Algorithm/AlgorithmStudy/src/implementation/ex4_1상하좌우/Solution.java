package implementation.ex4_1상하좌우;

import java.util.Scanner;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		int x=1, y=1;
		
		// 좌,우,상,하에 대한 이동거리
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		int N = sc.nextInt();		
		sc.nextLine();
		String[] plan = sc.nextLine().split(" ");
		
		for(String s : plan)
		{
			int direction=-1; // 이동할 방향을 인덱스로 변경
			int nx,ny; // 이동할 지점
			switch(s)
			{
			case "L": 
				direction=0;
				break;
			case "R":
				direction=1;
				break;
			case "U":
				direction=2;
				break;
			case "D":
				direction=3;
				break;
			}
			
			// 
			nx = x + dx[direction];
			ny = y + dy[direction];
			
			
			// 이동할 곳이 범위를 벗어나는 경우
			if(nx < 1 || nx > N 
					|| ny < 1 || ny > N)
			{
				continue;
			}
			else
			{
				x = nx;
				y = ny;
			}
		}
		
		System.out.printf("%d %d",y,x);
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sol();
	}

}
