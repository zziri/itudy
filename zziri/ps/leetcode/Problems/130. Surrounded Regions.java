// MEMO : 느리다 더 간단한 방법이 있으니까 한번 더 풀어야한다 꼭

/*
    Runtime: 6 ms, faster than 13.29% of Java online submissions for Surrounded Regions.
    Memory Usage: 47.4 MB, less than 7.25% of Java online submissions for Surrounded Regions.
*/
class Solution {
    private List<Integer> trace;
    private boolean[][] visited;
    private boolean escape;
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private void marking(char[][] board) {
        for (int val : trace) {
            int x = val & 0xFFF;
            int y = val >> 12;
            board[y][x] = 'X';
        }
    }

    private void clear() {
        trace.clear();
    }
    
    private void travel(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) {
            escape = true;
            return;
        }
        
        if (visited[y][x] || board[y][x] == 'X')
            return;
        
        visited[y][x] = true;
        trace.add(x | (y<<12));
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            travel(board, nx, ny);
        }
    }

    public void solve(char[][] board) {
        trace = new ArrayList<>();
        visited = new boolean[board.length][board[0].length];
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (board[y][x] == 'X' || visited[y][x])
                    continue;
                escape = false;
                travel(board, x, y);
                if (!escape) {
                    marking(board);
                }
                clear();
            }
        }
    }
}
