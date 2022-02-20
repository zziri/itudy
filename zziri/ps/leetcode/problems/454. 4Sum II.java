// MEMO : 답을 보는것도 공부..!

/*
    Runtime: 102 ms, faster than 40.00% of Java online submissions for 4Sum II.
    Memory Usage: 39 MB, less than 85.81% of Java online submissions for 4Sum II.
*/
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> dict = new HashMap<>();
        int ret = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int key = -(n1+n2);
                dict.put(key, dict.getOrDefault(key, 0) + 1);
            }
        }
        
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int key = n3+n4;
                ret += dict.getOrDefault(key, 0);
            }
        }
        return ret;
    }
}
