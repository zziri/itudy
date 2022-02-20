// MEMO : 쉬운 문제도 얕보지 말자

/*
    Runtime: 10 ms, faster than 96.21% of Java online submissions for Array Partition I.
    Memory Usage: 40.6 MB, less than 92.73% of Java online submissions for Array Partition I.
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i+=2) {
            ret += nums[i];
        }
        return ret;
    }
}
