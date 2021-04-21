class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] row = new HashMap[9];
        Map<Integer, Integer>[] column = new HashMap[9];
        Map<Integer, Integer>[] cell = new HashMap[9];
        
        for (int i=0; i<9; i++) {
            row[i] = new HashMap<>();
            column[i] = new HashMap<>();
            cell[i] = new HashMap<>();
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                int n = board[i][j] - '0';
                int cidx = (int)(j/3) + (int)((i/3)*3);
                row[i].put(n, row[i].getOrDefault(n, 0) + 1);
                column[j].put(n, column[j].getOrDefault(n, 0) + 1);
                cell[cidx].put(n, cell[cidx].getOrDefault(n, 0) + 1);
                
                if (row[i].get(n) > 1 || column[j].get(n) > 1 || cell[cidx].get(n) > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
