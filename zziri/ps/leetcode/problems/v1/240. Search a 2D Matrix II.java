// MEMO : 이렇게 푸는게 당연히 아니다. 다시 풀자

// Runtime: 12 ms, faster than 20.07% of Java online submissions for Search a 2D Matrix II.
// Memory Usage: 44.8 MB, less than 50.01% of Java online submissions for Search a 2D Matrix II.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
    
        return false;
    }
}
