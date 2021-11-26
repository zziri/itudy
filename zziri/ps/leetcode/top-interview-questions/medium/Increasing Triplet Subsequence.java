// MEMO : 거의 베낀 수준임.. 다시 풀어야함

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)    return false;
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (left >= nums[i]) {
                left = nums[i];
            } else if (mid >= nums[i]) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
