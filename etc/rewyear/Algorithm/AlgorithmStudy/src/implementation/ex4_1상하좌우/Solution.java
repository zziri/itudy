package implementation.ex4_1�����¿�;

import java.util.Scanner;

public class Solution {
	public static void sol() {
		Scanner sc = new Scanner(System.in);
		int x=1, y=1;
		
		// ��,��,��,�Ͽ� ���� �̵��Ÿ�
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		int N = sc.nextInt();		
		sc.nextLine();
		String[] plan = sc.nextLine().split(" ");
		
		for(String s : plan)
		{
			int direction=-1; // �̵��� ������ �ε����� ����
			int nx,ny; // �̵��� ����
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
			
			
			// �̵��� ���� ������ ����� ���
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
