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
		
		int n,e; // 노드 개수, 간선 개수
		
		n = sc.nextInt();
		e = sc.nextInt();
		
		// 부모 테이블 생성
		int[] p = new int[n+1];
		
		// 초기 부모 테이블의 루트노드 값은 자기 자신으로 설정
		for(int i=1; i<=n; i++)
			p[i]=i;
		
		// 간선 정보 리스트
		ArrayList<Node> list = new ArrayList<Node>(); 
		
		// 간선 정보 입력
		int nodeA, nodeB, weight;
		for(int i=0; i<e; i++)
		{
			nodeA = sc.nextInt();
			nodeB = sc.nextInt();
			weight = sc.nextInt();
			
			list.add(new Node(nodeA, nodeB, weight));
		}
		
		// 비용을 기준으로 오름차순으로 정렬
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight;
			}
		});
		
		// 최소 비용 저장할 리스트
		ArrayList<Integer> leastList = new ArrayList<Integer>(); 
		
		for(int i=0; i<e; i++) {
			int a = list.get(i).nodeA;
			int b = list.get(i).nodeB;
			
			// 사이클이 발생하면, 최소신장트리가 되지 못하므로 pass
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
