// MEMO : 변수 3개만으로 풀수 있으니까 다시 해보자

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
// Memory Usage: 40.5 MB, less than 70.55% of Java online submissions for Climbing Stairs.
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
