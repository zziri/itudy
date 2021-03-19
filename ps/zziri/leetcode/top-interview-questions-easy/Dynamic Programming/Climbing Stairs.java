// MEMO : dp는 전체 TC에 대해서 실행하자. 처음부터 dp 배열 전체를 초기화할 필요는 없음. (lazy하게 구현 가능)

class Solution {
    private static int[] dp = new int[46];
    Solution() {
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
    public int climbStairs(int n) {
        return dp[n];
    }
}
