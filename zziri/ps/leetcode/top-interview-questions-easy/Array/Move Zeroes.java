class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        int zerocnt = 0;
        
        for (int n : nums) {
            if (n == 0)
                zerocnt += 1;
            else
                digits.add(n);
        }
        
        for (int i=0; i<zerocnt; i++) {
            digits.add(0);
        }
        
        int i=0;
        for (Integer digit : digits) {
            nums[i++] = digit.intValue();
        }
    }
}
