// MEMO : 부분문제를 이용해서 현재범위의 문제를 풀자!

class Solution {
    private int[] dp;
    Solution() {
        dp = new int[101];
    }

    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        int ret = Math.max(dp[0], dp[1]);

        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            ret = Math.max(dp[i], ret);
        }

        return ret;
    }
}
