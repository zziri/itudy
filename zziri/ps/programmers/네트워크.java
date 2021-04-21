// MEMO : 완전탐색은 간편하게 해결하자

class Solution {
    private boolean[] visited;
    private void travel(int cur, int[][] graph) {
        visited[cur] = true;
        for (int next=0; next<graph[cur].length; next++) {
            if (graph[cur][next] != 0 && !visited[next]) {
                travel(next, graph);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int node=0; node<n; node++) {
            if (!visited[node]) {
                travel(node, computers);
                ++answer;
            }
        }
        return answer;
    }
}
