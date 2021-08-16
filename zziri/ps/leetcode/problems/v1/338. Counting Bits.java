// MEMO : 문제 풀때 항상 끄적끄적

// Runtime: 2 ms, faster than 42.99% of Java online submissions for Counting Bits.
// Memory Usage: 43.4 MB, less than 26.90% of Java online submissions for Counting Bits.
class Solution {
    private int getBitCount(int val) {
        int ret = 0;
        while (val > 0) {
            ret += val & 0x01;
            val >>= 1;
        }
        return ret;
    }
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i=0; i<=n; i++) {
            arr[i] = getBitCount(i);
        }
        return arr;
    }
}
