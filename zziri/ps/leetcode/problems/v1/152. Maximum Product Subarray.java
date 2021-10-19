// MEMO : 최적화 풀이 경험해보자

// Runtime: 91 ms, faster than 6.52% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 38.6 MB, less than 81.42% of Java online submissions for Maximum Product Subarray.

class Solution {
    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            int temp = nums[i];
            ret = Math.max(temp, ret);
            for (int j=i+1; j<nums.length; j++) {
                temp *= nums[j];
                ret = Math.max(temp, ret);
            }
        }
        return ret;
    }
}
