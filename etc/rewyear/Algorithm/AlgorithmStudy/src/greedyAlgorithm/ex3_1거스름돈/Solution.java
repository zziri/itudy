package greedyAlgorithm.ex3_1°Å½º¸§µ·;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int exchange = sc.nextInt();
		int cnt = 0;
		int[] coinTypes = {500,100,50,10};
		
		for(int coin : coinTypes) {
			cnt += (exchange / coin);
			exchange %= coin;
		}
		
		System.out.println(cnt);
		

	}

}
