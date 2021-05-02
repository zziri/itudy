// MEMO : DO NOT allocate another 2D matrix and do the rotation. 라는데 matrix, queue 모두 사용하지 않고 푸는 방법 시도해야해

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
    Memory Usage: 39.1 MB, less than 35.08% of Java online submissions for Rotate Image.
*/
class Solution {
    public void rotate(int[][] matrix) {
        Queue<Integer> q = new LinkedList<>();

        for (int y=0; y<matrix.length; y++) {
            for (int x=0; x<matrix[y].length; x++) {
                q.add(matrix[y][x]);
            }
        }

        for (int x=matrix[0].length-1; x>=0; x--) {
            for (int y=0; y<matrix.length; y++) {
                matrix[y][x] =  q.poll();
            }
        }
    }
}
