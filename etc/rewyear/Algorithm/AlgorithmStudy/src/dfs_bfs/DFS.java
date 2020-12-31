package dfs_bfs;

import java.util.ArrayList;

public class DFS {
	public static ArrayList<Integer>[] map;
	public static boolean[] checked;
	public static int degree;
	
	public static void init(int num) {
		degree = num;
		
		map = new ArrayList[degree];
		checked = new boolean[degree];
		
		for(int i=0; i<degree; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
	}
	
	public static void dfs(int node) {
		checked[node] = true;
		System.out.print(node);
		
		for(int i=0; i<map[node].size(); i++) {
			int next = map[node].get(i);
			if(checked[next] == false)
				dfs(next);
		}
	}

	public static void main(String[] args) {
		init(9);
		
		// ��� 1�� ����� ��� ���� ���� 
        map[1].add(2);
        map[1].add(3);
        map[1].add(8);
        
        // ��� 2�� ����� ��� ���� ���� 
        map[2].add(1);
        map[2].add(7);
        
        // ��� 3�� ����� ��� ���� ���� 
        map[3].add(1);
        map[3].add(4);
        map[3].add(5);
        
        // ��� 4�� ����� ��� ���� ���� 
        map[4].add(3);
        map[4].add(5);
        
        // ��� 5�� ����� ��� ���� ���� 
        map[5].add(3);
        map[5].add(4);
        
        // ��� 6�� ����� ��� ���� ���� 
        map[6].add(7);
        
        // ��� 7�� ����� ��� ���� ���� 
        map[7].add(2);
        map[7].add(6);
        map[7].add(8);
        
        // ��� 8�� ����� ��� ���� ���� 
        map[8].add(1);
        map[8].add(7);

        dfs(1);

	}

}
