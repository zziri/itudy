package etcAlgorithm;

import java.util.*;

public class DisjointSet {
	
	public static int findParent(int[] parent, int x) {
//		// 만약 루트노드가 아니라면, 루트노드를 찾을때 까지 재귀적으로 호출
//		if(parent[x] != x)
//			return findParent(parent,parent[x]);
//		else
//			return x;
		
		// 개선된 find 알고리즘, 루트 노드가 아닐경우 부모테이블을 루트노드로 갱신
		if(parent[x] != x)
			parent[x] = findParent(parent,parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		// 합치려는 두 노드의 루트 노드 찾기
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static void main(String[] args) {
		int v,e; // 노드개수, 간선개수
		int[] parent;
		Scanner sc = new Scanner(System.in);
	
		v = sc.nextInt();
		parent = new int[v+1]; // 부모 테이블 초기화
		for(int i=1; i<=v; i++) // 초기 부모는 자기자신
			parent[i] = i;
		
		e = sc.nextInt();
		int a,b;
		for(int i=0; i<e; i++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			
			unionParent(parent, a, b);
		}
		
		for(int i=1; i<=v; i++) {
			System.out.printf("%d ", findParent(parent, i));
		}
		
		System.out.println(" ");
		
		for(int i=1; i<=v; i++) {
			System.out.printf("%d ", parent[i]);
		}
			

	}

}
