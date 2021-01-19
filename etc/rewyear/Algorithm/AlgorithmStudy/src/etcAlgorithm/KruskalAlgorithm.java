package etcAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalAlgorithm {
	public static int findParent(int[] parent, int x) {
		if(parent[x] != x)
			parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		a=findParent(parent, a);
		b=findParent(parent, b);
		
		if(a < b)
			parent[b] = a;
		else 
			parent[a] = b;
	}
	
	public static class Node{
		public int nodeA;
		public int nodeB;
		public int weight;
		
		public Node(int nodeA, int nodeB, int weight) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.weight = weight;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n,e; // ��� ����, ���� ����
		
		n = sc.nextInt();
		e = sc.nextInt();
		
		// �θ� ���̺� ����
		int[] p = new int[n+1];
		
		// �ʱ� �θ� ���̺��� ��Ʈ��� ���� �ڱ� �ڽ����� ����
		for(int i=1; i<=n; i++)
			p[i]=i;
		
		// ���� ���� ����Ʈ
		ArrayList<Node> list = new ArrayList<Node>(); 
		
		// ���� ���� �Է�
		int nodeA, nodeB, weight;
		for(int i=0; i<e; i++)
		{
			nodeA = sc.nextInt();
			nodeB = sc.nextInt();
			weight = sc.nextInt();
			
			list.add(new Node(nodeA, nodeB, weight));
		}
		
		// ����� �������� ������������ ����
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});
		
		// �ּ� ��� ������ ����Ʈ
		ArrayList<Integer> leastList = new ArrayList<Integer>(); 
		
		for(int i=0; i<e; i++) {
			int a = list.get(i).nodeA;
			int b = list.get(i).nodeB;
			
			// ����Ŭ�� �߻��ϸ�, �ּҽ���Ʈ���� ���� ���ϹǷ� pass
			if(findParent(p, a)==findParent(p, b))
				continue;
			else {
				unionParent(p, a, b);
				leastList.add(list.get(i).weight);
			}
			
		}
		
		int sum=0;
		for(int i:leastList)
			sum+=i;
		System.out.println(sum);
	}

}
