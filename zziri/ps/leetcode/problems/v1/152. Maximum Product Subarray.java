// MEMO : 최적화를 해보긴 했지만 완벽하게 이해는 못했다

// Runtime: 1 ms, faster than 93.39% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 39.8 MB, less than 37.25% of Java online submissions for Maximum Product Subarray.

class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int ret = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++) {
            product *= nums[i];
            ret = Math.max(ret, product);
            if (product == 0)
                product = 1;
        }
        product = 1;

        for (int i=nums.length-1; i>=0; i--) {
            product *= nums[i];
            ret = Math.max(product, ret);
            if (product == 0)
                product = 1;
        }
        
        return ret;
    }
}
