package implementation.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt(); // ��
		int c = sc.nextInt(); // ��
		
		int[][] map = new int[r][c];
		// ��:0, ��:1, ��:2, ��:3
		int dx[] = {0,1,0,-1};
		int dy[] = {-1,0,1,0};
		
		// �������� ���� ���� ����
		int posX=sc.nextInt();
		int posY=sc.nextInt();
		int direction=sc.nextInt();
				
		// map �Է�(0: ����, 1: �ٴ�, 2: �湮)
		for(int i=0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				map[i][j] = sc.nextInt();
			}
		}
		
		// ������ �湮�ߴٰ� ó��
		int cnt=1;
		map[1][1] = 2; 
		
		// Ž�� ����
		while(true)
		{	
			int turn=0;
			
			// ���� üũ
			while(turn<4)
			{
				int nx = posX + dx[direction];
				int ny = posY + dy[direction];
				
				// ���� �湮�� ���� �ٴ��̰ų� �湮�� ���� ���
				if(map[ny][nx] == 1 || map[ny][nx] == 2)
				{
					direction = (direction+1)%4; // ���� ����
					turn++;
				}
				else // �湮 ������ ���� ���
				{
					map[ny][nx] = 2; // �湮 üũ
					posX = nx; // �̵�
					posY = ny;
					cnt++; // �湮 ĭ�� +1
					break;
				}
			}
			
			// �� ���� �� üũ�ߴµ��� �� ���� ���� ���, ��  �� üũ
			// ������ �齺��, �ٴٶ�� ����
			if(turn == 4) {
				int back = (direction+2)%4; 
				int bx = posX + dx[back];
				int by = posY + dy[back];
				
				if(map[by][bx] == 1) 
					break;
				else if(map[by][bx] == 2) {
					posX = bx; // �̵�
					posY = by;
				}
			}
				
		}
		System.out.println(cnt);
	}

}
