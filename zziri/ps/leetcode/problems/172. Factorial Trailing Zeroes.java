// MEMO : 유명한 문제니까 증명과정을 꼭 보자!

class Solution {
    public int trailingZeroes(int n) {
        if (n == 0)
            return 0;

        int ret = 0;
        while (n > 0) {
            ret += n/5;
            n /= 5;
        }

        return ret;
    }
}
