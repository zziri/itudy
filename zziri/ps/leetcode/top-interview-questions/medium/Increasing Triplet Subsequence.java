// MEMO : 다시 풀었지만 기억으로 푼 것 같다, 좀 더 나중에 다시 풀어야함

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= left) {
                left = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
