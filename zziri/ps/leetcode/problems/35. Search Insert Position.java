// MEMO : 이분탐색은 꾸준히 풀어야겠다

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
// Memory Usage: 43.1 MB, less than 69.96% of Java online submissions for Search Insert Position.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0, mid = 0;
        while (l <= r) {
            m = (l+r)/2;
            mid = nums[m];
            if (mid == target) {
                return m;
            } else if (mid > target) {
                r = m-1;
            } else if (mid < target) {
                l = m+1;
            }
        }
        
        return mid < target ? m+1 : m;
    }
}
