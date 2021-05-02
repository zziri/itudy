// MEMO : 값의 범위가 작을 때, visit 체크를 위한 별도의 공간을 할당하지 않아도 된다


/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    Memory Usage: 37 MB, less than 77.94% of Java online submissions for Spiral Matrix.
*/
class Solution {
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, 1, 0, -1};

    private boolean outOfRange(int x, int y, int n, int m) {
        return (x < 0 || y < 0 || x >= m || y >= n);
    }

    private boolean visited(int x, int y, int[][] arr) {
        return arr[y][x] == 999;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int i = 0, count = 0, x = 0, y = 0, limit = m*n;
        List<Integer> ret = new ArrayList<>();

        while (count < limit) {
            ret.add(matrix[y][x]);
            ++count;
            matrix[y][x] = 999;
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (outOfRange(nx, ny, n, m) || visited(nx, ny, matrix)) {
                i = (i+1)%4;
                nx = x + dx[i];
                ny = y + dy[i];
            }

            x = nx; y = ny;
        }

        return ret;
    }
}