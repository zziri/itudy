// MEMO : 함수 만드는거 귀찮아하지 않기

/*
    Runtime: 1 ms, faster than 20.87% of Java online submissions for Game of Life.
    Memory Usage: 37.2 MB, less than 76.90% of Java online submissions for Game of Life.
*/
class Node {
    int x;
    int y;
    int val;
    Node(int x, int y, int val) { this.x = x; this.y = y; this.val = val; }
}

class Solution {
    private final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    
    private boolean outOfRange(int[][] arr, int x, int y) {
        return (x < 0 || y < 0 || x >= arr[0].length || y >= arr.length);
    }
    
    private int getCount(int[][] arr, int x, int y) {
        int ret = 0;
        for (int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (outOfRange(arr, nx, ny))
                continue;
            ret += arr[ny][nx];
        }
        return ret;
    }
    
    public void gameOfLife(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        for (int y=0; y<board.length; y++) {
            for (int x=0; x<board[0].length; x++) {
                int aliveCount = getCount(board, x, y);
                if (board[y][x] == 1) {
                    if (aliveCount < 2 || aliveCount > 3) {
                        q.add(new Node(x, y, 0));
                    }
                } else {
                    if (aliveCount == 3) {
                        q.add(new Node(x, y, 1));
                    }
                }
            }
        }
        
        while (!q.isEmpty()) {
            int x = q.peek().x, y = q.peek().y, val = q.peek().val; q.poll();
            board[y][x] = val;
        }
    }
}