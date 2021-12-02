// MEMO : 간단하게 줄일 수 있는 아이디어!

//Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
//Memory Usage: 44.7 MB, less than 59.83% of Java online submissions for Search a 2D Matrix II.

class Solution {
    private boolean isOut(int x, int y, int n, int m) {
        return (x<0 || y<0 || x>=m || y>=n);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int y = 0, x = m-1;

        while (!isOut(x, y, n, m)) {
            if (target < matrix[y][x]) {
                x -= 1;
            } else if (target > matrix[y][x]) {
                y += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

