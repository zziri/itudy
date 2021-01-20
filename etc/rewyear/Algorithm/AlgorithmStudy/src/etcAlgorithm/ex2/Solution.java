package etcAlgorithm.ex2;

import java.util.*;

public class Solution {
	public static int n,m;
	public static int[] parent;
	
	public static int findParent(int x)
	{
		if(parent[x] != x)
			parent[x]=findParent(parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int a, int b)
	{
		a=findParent(a);
		b=findParent(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		parent = new int[n+1];
		
		for(int i=0; i<=n; i++)
			parent[i]=i;
		
		int mode,a,b;
		for(int i=0; i<m; i++) {
			mode = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(mode == 0)
				unionParent(a, b);
			else {
				if(findParent(a) == findParent(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
				
		}

	}

}
