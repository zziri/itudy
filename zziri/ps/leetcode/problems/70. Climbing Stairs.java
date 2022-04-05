// MEMO : 변수 3개로 메모이제이션

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
// Memory Usage: 39 MB, less than 86.81% of Java online submissions for Climbing Stairs.
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1, second = 2, ret = 0;
        for (int i=3; i<=n; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }
        return ret;
    }
}

