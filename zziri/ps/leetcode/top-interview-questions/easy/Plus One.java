class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        
        for (int i=digits.length-1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i-1] += digits[i] / 10;
                digits[i] %= 10;
            }
        }
        
        int[] ret = new int[digits[0] >= 10 ? digits.length+1 : digits.length];
        int idx=0;
        if (digits[0] >= 10) {
            ret[idx++] = digits[0]/10;
            digits[0] %= 10;
        }
        
        for (int digit : digits) {
            ret[idx++] = digit;
        }
        
        return ret;
    }
}
