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
		
		// 노드 1에 연결된 노드 정보 저장 
        map[1].add(2);
        map[1].add(3);
        map[1].add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        map[2].add(1);
        map[2].add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        map[3].add(1);
        map[3].add(4);
        map[3].add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        map[4].add(3);
        map[4].add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        map[5].add(3);
        map[5].add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        map[6].add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        map[7].add(2);
        map[7].add(6);
        map[7].add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        map[8].add(1);
        map[8].add(7);
        
        bfs(1);

	}

}
