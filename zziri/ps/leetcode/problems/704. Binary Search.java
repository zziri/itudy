// MEMO : 이제 이분탐색 감을 잡은듯 하다

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
// Memory Usage: 53.8 MB, less than 70.88% of Java online submissions for Binary Search.

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = (l+r)/2;
            int mid = nums[m];
            if (mid == target) {
                return m;
            } else if (mid < target) {
                l = m+1;
            } else if (mid > target) {
                r = m-1;
            }
        }
        return -1;
    }
}
