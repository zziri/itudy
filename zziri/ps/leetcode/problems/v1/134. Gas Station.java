// MEMO : 난잡하고 성능도 안 좋다. 다시 풀자.

// Runtime: 170 ms, faster than 5.08% of Java online submissions for Gas Station.
// Memory Usage: 39 MB, less than 83.09% of Java online submissions for Gas Station.
class Solution {
    private boolean isCanTravel(int[] gas, int[] cost, int n, int s) {
        int index = s;
        int remain = 0;
        for (int i=0; i<=n; i++) {
            if (i == 0) {
                remain += gas[index];
            } else if (i == n) {
                remain -= cost[(index+n-1)%n];
            } else {
                if (remain < cost[(index+n-1)%n])
                    return false;
                remain += gas[index] - cost[(index+n-1)%n];
            }
            if (remain < 0) {
                return false;
            }
            index = (index+1)%n;
        }
        return true;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i=0; i<n; i++) {
            if (isCanTravel(gas, cost, n, i))
                return i;
        }
        return -1;
    }
}
