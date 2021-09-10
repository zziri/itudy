// MEMO : 문제 조건을 잘 보고 반례를 생각하자

import java.util.*;

class Solution {
    private String[] answer;
    private void dfs(int depth, boolean[] used, String[][] tickets, List<String> path, String current) {
        if (answer != null)
            return;
        
        if (depth == tickets.length) {
            answer = path.toArray(new String[path.size()]);
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (used[i])
                continue;
            
            if (current.equals(tickets[i][0])) {
                used[i] = true;
                path.add(tickets[i][1]);
                dfs(depth+1, used, tickets, path, tickets[i][1]);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (l, r) -> {
            if (l[0].equals(r[0]))
                return l[1].compareTo(r[1]);
            else
                return l[0].compareTo(r[0]);
        });
        
        boolean[] used = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(0, used, tickets, path, "ICN");
        
        return answer;
    }
}
