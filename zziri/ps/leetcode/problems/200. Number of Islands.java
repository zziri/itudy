// MEMO : 다른 사람들 풀이도 확인해보자

// Runtime: 6 ms, faster than 29.47% of Java online submissions for Number of Islands.
// Memory Usage: 56 MB, less than 15.90% of Java online submissions for Number of Islands.

class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    
    private boolean isOut(int x, int y, int n, int m) {
        return (x < 0 || y < 0 || x >= m || y >= n);
    }
    
    private void flood(char[][] map, int x, int y) {
        map[y][x] = '0';
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOut(nx, ny, map.length, map[0].length) || map[ny][nx] == '0')
                continue;
            flood(map, nx, ny);
        }
    }
    
    public int numIslands(char[][] grid) {
        int ret = 0;
        for (int y=0; y<grid.length; y++) {
            for (int x=0; x<grid[y].length; x++) {
                if (grid[y][x] == '1') {
                    flood(grid, x, y);
                    ret += 1;
                }
            }
        }
        return ret;
    }
}
