// MEMO : 배열이 작으면 변수 몇 개에 저장가능!

/*
    Runtime: 1 ms, faster than 92.14% of Java online submissions for Set Matrix Zeroes.
    Memory Usage: 40.2 MB, less than 96.97% of Java online submissions for Set Matrix Zeroes.
*/
class Solution {
    private int[] row;
    private int[] col;
    
    Solution() {
        row = new int[7];
        col = new int[7];
    }
    
    private void check(int r, int c) {
        row[r>>5] |= (0x01 << (r%32));
        col[c>>5] |= (0x01 << (c%32));
    }
    
    private boolean isCheck(int r, int c) {        
        return ((row[r>>5] & (0x01 << (r%32))) != 0) || ((col[c>>5] & (0x01 << (c%32))) != 0);
    }
    
    public void setZeroes(int[][] matrix) {
        for (int i=0; i<7; i++) {
            row[i] = col[i] = 0;
        }
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    check(i, j);
                }                
            }
        }
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (isCheck(i, j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
