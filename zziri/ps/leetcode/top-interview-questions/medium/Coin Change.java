// MEMO : 무조건 bottom-up 으로 생각할 필요없다. top-down 사고에서 bottom-up 점화식을 구할 수도 있다.

class Solution {
    private static int[] dp = new int[10001];
    
    public int coinChange(int[] coins, int amount) {
        for (int i=1; i<dp.length; i++) {
            dp[i] = 10001;
        }
        dp[0] = 0;

        for (int i=1; i<=amount; i++) {
            for (int coin : coins) {
                if (coin > i)
                    continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }

        return dp[amount] < 10001 ? dp[amount] : -1;
    }
}
