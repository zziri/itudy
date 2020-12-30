package implementation.ex3;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		String pos = sc.next(); 
				
		int x = pos.charAt(0) - 'a' + 1; // 시작 인덱스 1로 맞춰주기 위해 +1
		int y = Character.getNumericValue(pos.charAt(1)); 
		int cnt = 0;
		
		for(int i=0; i<8; i++)
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 1 || nx > 8	|| ny < 1 || ny > 8)
				continue;
			else
				cnt++;
		}
		
		System.out.println(cnt);
	}

}
