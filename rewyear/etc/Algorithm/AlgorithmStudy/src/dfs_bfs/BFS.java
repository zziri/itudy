package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(node);
		checked[node] = true;		
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.printf("%d ", num);
			
			for(int i=0; i<map[num].size(); i++) {
				int next = map[num].get(i);
				
				if(checked[next] == false) {
					checked[next] = true;
					queue.add(next);
				}
			}
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
        
        bfs(1);

	}

}
