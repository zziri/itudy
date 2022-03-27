// MEMO : 제대로 이해 안된듯 다시 풀자

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
// Memory Usage: 41.6 MB, less than 85.94% of Java online submissions for Find Peak Element.

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] < nums[m+1]) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
