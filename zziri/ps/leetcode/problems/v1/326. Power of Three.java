// MEMO : Math Class의 method들은 부하가 큰 편이다(특히 pow같은 함수), 가끔은 Naive한 방법이 더 좋을 때도 있다. Pow를 사용하지 않는 방법도 고민해볼 필요가 있다

// 17msec, 22.54%
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;
    }
}

// 21msec, 12.47%
/*
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n==0) {
            return false;
        }

        double x = Math.log(n)/Math.log(3);
        return (long)n == (long)Math.pow(3, (long)Math.round(x));
    }
}
*/