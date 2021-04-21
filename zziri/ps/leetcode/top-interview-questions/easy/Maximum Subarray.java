// MEMO : 배열로 cache를 잡아 구현한 DP는 배열이 아니라 변수 몇개로도 구현 가능할 지도 모른다!

class Solution {
    public int maxSubArray(int[] nums) {
        int val = nums[0];
        int ret = val;

        for (int i=1; i<nums.length; i++) {
            val = Math.max(val + nums[i], nums[i]);
            ret = Math.max(ret, val);
        }

        return ret;
    }
}
