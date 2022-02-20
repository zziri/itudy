// MEMO : 끄적거리며 시뮬레이션 해보면 처음에는 BFS를 생각했더라도 메모이제이션 솔루션을 떠올릴 수 있는 문제

// 0 ms, 100 %
class Solution {
    private int[][] map;
    private void init(int m, int n) {
        map = new int[m][n];
        for (int x=0; x<n; x++) {
            map[0][x] = 1;
        }
        for (int y=0; y<m; y++) {
            map[y][0] = 1;
        }
    }
    
    private void counting(int m, int n) {
        for (int y=1; y<m; y++) {
            for (int x=1; x<n; x++) {
                map[y][x] = map[y-1][x] + map[y][x-1];
            }
        }
    }
    
    private int getAnswer(int m, int n) {
        return map[m-1][n-1];
    }
    
    public int uniquePaths(int m, int n) {
        init(m, n);
        counting(m, n);
        return getAnswer(m, n);
    }
}
