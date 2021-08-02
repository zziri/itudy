// MEMO : Two Pointer!!

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
// Memory Usage: 37.6 MB, less than 51.21% of Java online submissions for Remove Element.
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, back = nums.length-1, ret = nums.length;
        while (i < nums.length && back >= i) {
            if (nums[i] == val) {
                nums[i] = nums[back--];
                ret -= 1;
                continue;
            }
            i += 1;
        }
        return ret;
    }
}
