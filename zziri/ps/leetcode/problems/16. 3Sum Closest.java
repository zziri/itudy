// 간단한 방법으로 풀이한건 좋은데, 너무 느림

// Runtime: 460 ms, faster than 5.03% of Java online submissions for 3Sum Closest.
// Memory Usage: 43.7 MB, less than 8.38% of Java online submissions for 3Sum Closest.

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDist = Integer.MAX_VALUE;
        int ret = 0;
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int dist = Math.abs(target-sum);
                    if (dist < minDist) {
                        ret = sum;
                        minDist = dist;
                    }
                }
            }
        }
        return ret;
    }
}
