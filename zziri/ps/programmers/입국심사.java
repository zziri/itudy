import java.util.*;

class Solution {
    private long getMaxTime(int[] times, int n) {
        int maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        return (long)maxTime*(long)n;
    }

    private long search(int n, int[] times, long max) {
        long low = 0;
        long high = max;
        long ret = Long.MAX_VALUE;
        while (low <= high) {
            long mid = (low + high)/2;
            long value = 0;
            for (int time : times) {
                value += mid/(long)time;
            }
            if (value < (long)n) {
                low = mid + 1;
            } else if (value >= (long)n) {
                ret = Math.min(ret, mid);
                high = mid - 1;
            }
        }
        return ret;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long max = getMaxTime(times, n);
        answer = search(n, times, max);
        return answer;
    }
}
