class Solution {
    public int reverse(int x) {
        int minus = 1;
        if (x < 0) {
            minus = -1;
            x = -x;
        }
        long ret = 0;
        while (x > 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        ret *= minus;
        if (ret < (int)-2e31 || ret > (int)2e31-1)
            return 0;
        else
            return (int)ret;
    }
}
