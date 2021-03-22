// MEMO : 에라토스테네스의 체를 구현할 때에는 제곱근 기억!

class Solution {
    private boolean[] arr;
    Solution() {
        arr = new boolean[5000001];
        for (int i=0; i<=2237; i++) {
            if (i < 2)
                arr[i] = true;
            else {
                if (arr[i])
                    continue;
                else {
                    for (int j=i+i; j<arr.length; j+=i) {
                        arr[j] = true;
                    }
                }
            }
        }
    }

    public int countPrimes(int n) {
        int ret = 0;
        for (int i=2; i<n; i++) {
            if (!arr[i])
                ++ret;
        }
        return ret;
    }
}