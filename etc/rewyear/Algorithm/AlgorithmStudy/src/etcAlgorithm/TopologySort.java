package etcAlgorithm;

import java.util.*;

public class TopologySort {
	public static int n,e; 
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 
	public static int[] inDgr; 
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// ���������� 0�� ���� result �迭�� ����
		for(int i=1; i<= n; i++) {
			if(inDgr[i] == 0) 
				q.offer(i);
		}
		
		// ť�� �� ������
		while(!q.isEmpty()) 
		{
			int now = q.poll();
			result.add(now);
			
			for(int i=0; i<graph.get(now).size(); i++) 
			{
				int d = graph.get(now).get(i);
				inDgr[d]--;
				if(inDgr[d]==0)
					q.offer(d);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // ��� ����
		e = sc.nextInt(); // ���� ����
		
		for(int i=0; i<=n; i++) // �׷��� �ʱ�ȭ
			graph.add(new ArrayList<Integer>());
		
		inDgr = new int[n+1]; // �������� �迭 �ʱ�ȭ

		// ���� ���� �Է�, to�� �ԷµǴ� ���� ���������� 1����
		int from,to;
		for(int i=0; i<e; i++) 
		{
			from = sc.nextInt();
			to = sc.nextInt();
			
			graph.get(from).add(to);
			inDgr[to]++;
		}
		
		// ��������
		topologySort();
		
		for(int i:result)
			System.out.printf("%d ", i);
		
	}

}
