// MEMO : DFS 보단 BFS가 간단!

import java.util.*;

class Solution {
    
    private boolean[] picked;
    
    private int diff(String s1, String s2) {
        int ret = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ret += 1;
            }
        }
        return ret;
    }
    
    private int bfs(String begin, String target, String[] words) {
        int ret = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int step = q.peek().step;
            q.poll();
            
            if (word.equals(target)) {
                ret = step;
                break;
            }
            
            for (int i=0; i<words.length; i++) {
                if (!picked[i] && diff(words[i], word) == 1) {
                    picked[i] = true;
                    q.add(new Node(words[i], step+1));
                }
            }
        }
        return ret;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        picked = new boolean[words.length];
        answer = bfs(begin, target, words);
        return answer;
    }
    
    static class Node {
        public String word;
        public int step;
        Node(String word, int step) { this.word = word; this.step = step; }
    }
}
