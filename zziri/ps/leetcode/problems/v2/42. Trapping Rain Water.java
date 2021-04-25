// MEMO : 투 포인터에 겁먹을 필요 없다. 그냥 하나씩 해도 된다.

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
    Memory Usage: 38.6 MB, less than 45.58% of Java online submissions for Trapping Rain Water.
*/
class Solution {
    private int getMaxIndex(int[] arr) {
        int ret = 0, val = 0;
        for (int i=0; i<arr.length; i++) {
            if (val < arr[i]) {
                ret = i;
                val = arr[i];
            }
        }
        return ret;
    }

    public int trap(int[] height) {
        int maxIndex = getMaxIndex(height);
        int maxHeight = 0;
        int ret = 0;

        for (int l=0; l<maxIndex; l++) {
            if (height[l] > maxHeight) {
                maxHeight = height[l];
            } else {
                ret += maxHeight - height[l];
            }
        }

        maxHeight = 0;
        for (int r=height.length-1; r>maxIndex; r--) {
            if (height[r] > maxHeight) {
                maxHeight = height[r];
            } else {
                ret += maxHeight - height[r];
            }
        }

        return ret;
    }
}
