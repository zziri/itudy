package etcAlgorithm.ex3;

import java.util.*;

public class Solution {
	public static int n,m;
	public static ArrayList<Node> list = new ArrayList<Node>();
	public static int[] parent;
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static class Node{
		public int nodeA;
		public int nodeB;
		public int weight;
		
		public Node(int a, int b, int weight) {
			this.nodeA = a;
			this.nodeB = b;
			this.weight = weight;
		}
		
	}
	
	public static int findParent(int x) {
		if(parent[x] != x)
			parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int a, int b) {
		a=findParent(a);
		b=findParent(b);
		
		if(a<b)
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
			parent[i] = i;
		
		int a,b,weight;
		for(int i=0; i<m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			weight = sc.nextInt();
			
			list.add(new Node(a,b,weight));
		}
		
		Collections.sort(list,new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.weight - o2.weight; 
			}
		});
		
		for(int i=0; i<list.size(); i++)
		{
			int from = list.get(i).nodeA;
			int to = list.get(i).nodeB;
			
			if(findParent(from) == findParent(to))
				continue;
			else {
				unionParent(from, to);
				result.add(list.get(i).weight);
			}
		}
		
		int sum =0;
		for(int i=0; i<result.size()-1; i++) 
			sum += result.get(i);
		
		System.out.println(sum);
	}

}
