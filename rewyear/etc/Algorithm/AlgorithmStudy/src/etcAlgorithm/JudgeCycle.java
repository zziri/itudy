package etcAlgorithm;

import java.util.*;

public class JudgeCycle {
	public static int findParent(int[] parent, int x) {
		if(parent[x] != x)
			parent[x] = findParent(parent, parent[x]);
		return parent[x];
		
	}
	
	public static void unionParent(int[] parent, int a, int b)
	{
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a < b)
			parent[b] = a;
		else 
			parent[a] = b;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int n,e; // 노드 개수, 간선 개수
		
		n = sc.nextInt();
		e = sc.nextInt();
		
		// 부모 테이블 생성
		int[] p = new int[n+1];
		
		// 초기 부모 테이블의 루트노드 값은 자기 자신으로 설정
		for(int i=1; i<=n; i++)
			p[i]=i;
		
		int a, b;
		boolean cycle = false;
		for(int i=0; i<e; i++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(findParent(p, a) == findParent(p, b)) // 사이클이 발생한경우 cycle 표기 및 break
			{
				cycle=true;
				break;
			}
			else // 사이클이 발생하지 않았을 경우
			{
				unionParent(p, a, b);
			}
			
		}
		
		if(cycle)
			System.out.println("사이클이 발생하였습니다.");
		else
			System.out.println("사이클이 발생하지 않았습니다.");
		
		
		
	}

}
