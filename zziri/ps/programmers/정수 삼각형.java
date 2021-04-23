// MEMO : 당장 생각이 안날 때는 일단 함수로 쪼개기

import java.util.*;

class Solution {
    private int getLeftParent(int[][] arr, int x, int y) {
        if (x == 0)
            return 0;
        else
            return arr[y-1][x-1];
    }

    private int getRightParent(int[][] arr, int x, int y) {
        if (x == arr[y].length-1)
            return 0;
        else
            return arr[y-1][x];
    }

    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        if (triangle.length == 1)
            return triangle[0][0];

        for (int y=1; y<triangle.length; y++) {
            for (int x=0; x<triangle[y].length; x++) {
                int left = getLeftParent(triangle, x, y);
                int right = getRightParent(triangle, x, y);
                triangle[y][x] += Math.max(left, right);
                answer = Math.max(answer, triangle[y][x]);
            }
        }
        return answer;
    }
}
