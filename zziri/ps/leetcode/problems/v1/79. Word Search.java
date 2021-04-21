// MEMO : visit 체크는 재귀 호출 후에 처리해도 된다

/*
    Runtime: 59 ms, faster than 53.22% of Java online submissions for Word Search.
    Memory Usage: 36.7 MB, less than 97.40% of Java online submissions for Word Search.
*/
class Solution {
    private boolean result;
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {-1, 0, 1, 0};
    private boolean[][] visit;
    
    private boolean isOut(int x, int y, char[][] board) {
        return (x < 0 || y < 0 || x >= board[0].length || y>= board.length);
    }
    
    private void recur(int depth, char[] str, char[][] board, int x, int y) {
        if (result)
            return;
        if (depth == str.length-1) {
            result = true;
            return;
        }

        visit[y][x] = true;
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOut(nx, ny, board) || board[ny][nx] != str[depth+1] || visit[ny][nx])
                continue;
            recur(depth+1, str, board, nx, ny);
        }

        visit[y][x] = false;
    }
    
    public boolean exist(char[][] board, String word) {
        result = false;
        visit = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();

        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[y].length; x++) {
                if (board[y][x] == chars[0]) {
                    recur(0, chars, board, x, y);
                    if (result)
                        return true;
                }
            }
        }

        return false;
    }
}