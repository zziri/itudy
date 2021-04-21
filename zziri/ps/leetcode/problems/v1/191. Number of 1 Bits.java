// MEMO : set된 bit 하나씩 없애는 방법!!

// 0msec, 100%
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            ++ret;
            n &= (n-1);
        }
        return ret;
    }
}

// 0msec, 100%
/*
public class Solution {
    public int hammingWeight(int n) {
        int ret = 0;
        int cnt = 32;
        while (cnt-- > 0) {
            ret += n & 0x01;
            n >>= 1;
        }
        return ret;
    }
}
*/