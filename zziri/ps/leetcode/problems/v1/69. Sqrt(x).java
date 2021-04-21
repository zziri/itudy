// MEMO : 손으로 직접 써가면서 풀어야해...!

class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        
        int l = 0, h = x, mid = 0;
        while (l < h) {
            mid = l+((h-l)>>1);
            if (mid == l) {
                if (l*l < x) {
                    return l;
                } else {
                    return h;
                }
            }

            long square = (long)mid*(long)mid;
            if (square < x) {
                l = mid;
            } else if (square > x) {
                h = mid;
            } else {
                return mid;
            }
        }
        
        return l;
    }
}
