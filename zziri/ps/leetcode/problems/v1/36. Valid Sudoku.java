class Solution {
    
    private boolean isValidRow(char[][] board, int y) {
        boolean[] check = {false, false, false, false, false, false, false, false, false, false};
        for(int x=0; x<board.length; x++) {
            if (board[y][x] == '.')
                continue;
            int n = board[y][x] - '0';
            if (check[n])
                return false;
            else
                check[n] = true;
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int x) {
        boolean[] check = {false, false, false, false, false, false, false, false, false, false};
        for (int y=0; y<board.length; y++) {
            if (board[y][x] == '.')
                continue;
            int n = board[y][x] - '0';
            if (check[n])
                return false;
            else
                check[n] = true;
        }
        return true;
    }
    
    private boolean isValidCell(char[][] board, int c, int r) {
        boolean[] check = {false, false, false, false, false, false, false, false, false, false};
        for(int x=c; x<c+3; x++) {
            for(int y=r; y<r+3; y++) {
                if (board[y][x] == '.')
                    continue;
                int n = board[y][x] - '0';
                if (check[n])
                    return false;
                else
                    check[n] = true;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<board.length; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        
        for (int i=0; i<board.length; i++) {
            if (!isValidColumn(board, i)) {
                return false;
            }
        }
        
        for (int x=0; x<board[0].length; x += 3) {
            for(int y=0; y<board.length; y += 3) {
                if (!isValidCell(board, x, y)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
