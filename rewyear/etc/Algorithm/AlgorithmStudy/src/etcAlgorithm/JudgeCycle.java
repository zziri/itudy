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
		
		int n,e; // ��� ����, ���� ����
		
		n = sc.nextInt();
		e = sc.nextInt();
		
		// �θ� ���̺� ����
		int[] p = new int[n+1];
		
		// �ʱ� �θ� ���̺��� ��Ʈ��� ���� �ڱ� �ڽ����� ����
		for(int i=1; i<=n; i++)
			p[i]=i;
		
		int a, b;
		boolean cycle = false;
		for(int i=0; i<e; i++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(findParent(p, a) == findParent(p, b)) // ����Ŭ�� �߻��Ѱ�� cycle ǥ�� �� break
			{
				cycle=true;
				break;
			}
			else // ����Ŭ�� �߻����� �ʾ��� ���
			{
				unionParent(p, a, b);
			}
			
		}
		
		if(cycle)
			System.out.println("����Ŭ�� �߻��Ͽ����ϴ�.");
		else
			System.out.println("����Ŭ�� �߻����� �ʾҽ��ϴ�.");
		
		
		
	}

}
