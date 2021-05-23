// MEMO : 앞으로, 뒤로 순회

/*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
    Memory Usage: 50 MB, less than 36.37% of Java online submissions for Product of Array Except Self.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] x = new int[nums.length];
        
        int product = 1;
        x[0] = product;
        for (int i=1; i<nums.length; i++) {
            product *= nums[i-1];
            x[i] = product;
        }
        
        product = 1;
        for (int i=nums.length-2; i>=0; i--) {
            product *= nums[i+1];
            x[i] *= product;
        }
        return x;
    }
}
