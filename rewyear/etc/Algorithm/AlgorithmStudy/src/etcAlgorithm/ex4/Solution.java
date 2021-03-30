package etcAlgorithm.ex4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int n;
	public static int[] inDegree = new int[501];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] time = new int[501];
	
	public static void topologySort() {
		int[] result = new int[501];
		
		System.arraycopy(time, 0, result, 0, result.length);
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		// ���������� 0�� ���� result �迭�� ����
		for(int i=1; i<= n; i++) {
			if(inDegree[i] == 0) 
				q.offer(i);
		}
		
		// ť�� �� ������
		while(!q.isEmpty()) 
		{
			int now = q.poll();
			
			// �ش� ���(now)�� ����Ǿ� �ִ� �������� 1 ����
			for(int i=0; i<graph.get(now).size(); i++) 
			{
				int d = graph.get(now).get(i);
				result[d] = Math.max(result[d], result[now] + time[d]);
				inDegree[d]--;
				if(inDegree[d]==0)
					q.offer(d);
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // ���� ����
		
		for(int i=0; i<=n; i++) // �׷��� �ʱ�ȭ
			graph.add(new ArrayList<Integer>());
		
		for(int i=1; i<=n; i++) {
			int x = sc.nextInt();
			time[i] = x; // ���� �ð� �Է� 
			
			while(true) // ���� ���� �Է�
			{
				x = sc.nextInt();
				if(x == -1) break;
				
				inDegree[i]++;
				graph.get(x).add(i);
			}
		}
		
		topologySort();

	}

}
