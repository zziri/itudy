class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        for (int i=0; i<height.length - 1; i++) {
            for(int j=i+1; j<height.length; j++) {
                int h = Math.min(height[i], height[j]);
                ret = Math.max(ret, h*(j-i));
            }
        }
        return ret;
    }
}
