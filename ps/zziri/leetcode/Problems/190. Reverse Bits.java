// MEMO : 하나씩 >> 하면 LSB부터 MSB 방향으로 비트 값을 가져올 수 있다. 비트문제에서는 부호를 신경쓸 필요가 없는 경우가 많다.

public class Solution {
    public int reverseBits(int n) {
        int cnt = 32;
        int ret = 0;
        while (cnt-- > 0) {
            ret <<= 1;
            ret |= n & 0x01;
            n >>= 1;
        }
        return ret;
    }
}
