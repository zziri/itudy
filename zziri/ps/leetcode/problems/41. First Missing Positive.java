// MEMO : extra space 없이 푸는 방법 이해를 아직 못했다

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for First Missing Positive.
    Memory Usage: 36.4 MB, less than 86.92% of Java online submissions for First Missing Positive.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] bucket = new boolean[nums.length+1];
        for (int n : nums) {
            if (n > 0 && n < bucket.length) {
                bucket[n] = true;
            }
        }
        int ret;
        for (ret = 1; ret < bucket.length; ret++) {
            if (!bucket[ret])
                break;
        }
        return ret;
    }
}