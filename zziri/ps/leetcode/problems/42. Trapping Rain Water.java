// MEMO : 시뮬레이션 해보면 쉽게 풀리긴 하지만 개선이 필요

/*
    Runtime: 2 ms, faster than 21.48% of Java online submissions for Trapping Rain Water.
    Memory Usage: 38.7 MB, less than 33.97% of Java online submissions for Trapping Rain Water.
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ret = 0;

        for (int s=0; s<n-1; s++) {
            if (height[s] > height[s+1]) {
                int e = 0;
                for (e=s+1; e<n; e++) {
                    if (height[s] <= height[e]) {
                        break;
                    }
                }
                if (e < n && height[s] <= height[e]) {
                    for (int i=s+1; i<e; i++) {
                        ret += height[s] - height[i];
                        height[i] = height[s];
                    }
                    s = e-1;
                }
            }
        }

        for (int s=n-1; s>0; s--) {
            if (height[s] > height[s-1]) {
                int e = 0;
                for (e=s-1; e>=0; e--) {
                    if (height[e] >= height[s]) {
                        break;
                    }
                }
                if (e >= 0 && height[e] >= height[s]) {
                    for (int i=s-1; i>e; i--) {
                        ret += height[s] - height[i];
                        height[i] = height[s];
                    }
                    s = e+1;
                }
            }
        }

        return ret;
    }
}
