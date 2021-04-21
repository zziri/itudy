// MEMO : 무조건 리스트로 구현하는 습관은 안 좋다

class Solution {
    private int getSum(int n) {
        long ret = 0;
        while (n > 0) {
            ret += (n%10)*(n%10);
            n /= 10;
        }
        return (int)ret;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            if (n == 1)
                return true;
            set.add(n);
            n = getSum(n);
        }
        return false;
    }
}
