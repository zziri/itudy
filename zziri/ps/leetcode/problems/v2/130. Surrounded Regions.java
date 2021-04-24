// MEMO : 키보드가 아니고 펜으로 풀기! 아무리 간단해보이는 문제라도

/*
    Runtime: 1 ms, faster than 99.49% of Java online submissions for Surrounded Regions.
    Memory Usage: 40.7 MB, less than 91.95% of Java online submissions for Surrounded Regions.
*/
class Solution {
    private char[][] arr;
    private int n;
    private int m;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    private boolean outOfRange(int x, int y, int n, int m) {
        return (x < 0 || y < 0 || x >= m || y >= n);
    }
    
    private void floodfill(int x, int y, char mark) {
        arr[y][x] = mark;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!outOfRange(nx, ny, n, m) && arr[ny][nx] == 'O') {
                floodfill(nx, ny, mark);
            }
        }
    }
    
    private void checkAliveArea() {
        for (int y=0; y<n; y++) {
            int jump = (y == 0 || y == n-1) ? 1 : m-1;
            for (int x=0; x<m; x+=jump) {
                if (arr[y][x] == 'O') {
                    floodfill(x, y, ' ');
                }
            }
        }
    }
    
    private void killAndRollBack() {
        for (int y=0; y<n; y++) {
            for (int x=0; x<m; x++) {
                if (arr[y][x] == 'O')
                    arr[y][x] = 'X';
                else if (arr[y][x] == ' ')
                    arr[y][x] = 'O';
            }
        }
    }
    
    public void solve(char[][] board) {
        arr = board; n = arr.length; m = arr[0].length;
        checkAliveArea();
        killAndRollBack();
    }
}
