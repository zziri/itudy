class Solution {
    private int getWaitingTerm(int[] t, int idx) {
        int ret = 0;
        int base = t[idx];
        for (int i=idx+1; i<t.length; i++) {
            if (base < t[i]) {
                ret = i - idx;
                break;
            }
        }
        return ret;
    }
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        for (int i=0; i<T.length-1; i++) {
            ret[i] = getWaitingTerm(T, i);
        }
        return ret;
    }
}
