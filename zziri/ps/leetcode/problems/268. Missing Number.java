// MEMO : 정수의 집합을 다룰 때는 덧셈이 효과적일 수도

class Solution {    
    public int missingNumber(int[] nums) {
        int ret = (nums.length*(nums.length+1))>>1;
        for (int n : nums) {
            ret -= n;
        }
        return ret;
    }
}
