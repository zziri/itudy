// MEMO : 입력이 클 때, 먼저 log 시간복잡도를 생각하자

class Solution {
    private double getPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        double ret = getPow(x, n/2);
        if ((n & 0x01) == 0) {
            ret *= ret;
        } else {
            ret *= (ret*x);
        }
        return ret;
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double ret = getPow(x, n);
        return ret;
    }
}
