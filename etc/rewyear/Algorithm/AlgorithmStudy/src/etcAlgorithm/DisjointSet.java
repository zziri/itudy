package etcAlgorithm;

import java.util.*;

public class DisjointSet {
	
	public static int findParent(int[] parent, int x) {
//		// ���� ��Ʈ��尡 �ƴ϶��, ��Ʈ��带 ã���� ���� ��������� ȣ��
//		if(parent[x] != x)
//			return findParent(parent,parent[x]);
//		else
//			return x;
		
		// ������ find �˰���, ��Ʈ ��尡 �ƴҰ�� �θ����̺��� ��Ʈ���� ����
		if(parent[x] != x)
			parent[x] = findParent(parent,parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		// ��ġ���� �� ����� ��Ʈ ��� ã��
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static void main(String[] args) {
		int v,e; // ��尳��, ��������
		int[] parent;
		Scanner sc = new Scanner(System.in);
	
		v = sc.nextInt();
		parent = new int[v+1]; // �θ� ���̺� �ʱ�ȭ
		for(int i=1; i<=v; i++) // �ʱ� �θ�� �ڱ��ڽ�
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
