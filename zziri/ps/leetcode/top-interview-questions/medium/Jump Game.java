// MEMO : 바로 생각난 것이더라도 그게 답일 수도, DP라고 무조건 O(n)으로 줄이려고 집착하지 말자

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[0] = true;

        for (int i=0; i<nums.length-1; i++) {
            if (!memo[i])
                break;
            int limit = Math.min(nums[i] + i, nums.length-1);
            for (int j=i+1; j<=limit; j++) {
                memo[j] = true;
            }
            if (memo[nums.length-1])
                break;
        }

        return memo[nums.length-1];
    }
}