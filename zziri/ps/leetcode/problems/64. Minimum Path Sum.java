// MEMO : BFS로 풀 때에는 꼭 O(n)인지 체크하자

// Runtime: 1 ms, faster than 98.79% of Java online submissions for Minimum Path Sum.
// Memory Usage: 41.9 MB, less than 43.33% of Java online submissions for Minimum Path Sum.
class Solution {
    private int getUpperValue(int x, int y, int[][] arr) {
        return y == 0 ? Integer.MAX_VALUE : arr[y-1][x];
    }
    
    private int getLeftValue(int x, int y, int[][] arr) {
        return x == 0 ? Integer.MAX_VALUE : arr[y][x-1];
    }
    
    private int getMinCost(int x, int y, int[][] arr) {
        if (x == 0 && y == 0)
            return 0;
        
        int upperValue = getUpperValue(x, y, arr);
        int leftValue = getLeftValue(x, y, arr);
        
        return Math.min(upperValue, leftValue);
    }
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for (int y=0; y<n; y++) {
            for (int x=0; x<m; x++) {
                grid[y][x] += getMinCost(x, y, grid);
            }
        }
        
        return grid[n-1][m-1];
    }
}
