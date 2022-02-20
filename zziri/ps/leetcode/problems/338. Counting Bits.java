// MEMO : dp는 의외로 많이 쓰인다

// Runtime: 1 ms, faster than 99.83% of Java online submissions for Counting Bits.
// Memory Usage: 43 MB, less than 73.90% of Java online submissions for Counting Bits.
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if (n > 0)
            dp[1] = 1;
        for (int i=2; i<=n; i++) {
            if ((i & 1) == 0) {
                dp[i] = dp[i>>1];
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp;
    }
}
