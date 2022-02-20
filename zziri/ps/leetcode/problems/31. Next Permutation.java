// MEMO : Next Permutation은 줄어드는 곳 찾기, 큰 거 찾기, 뒤집기

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
    Memory Usage: 39.2 MB, less than 44.07% of Java online submissions for Next Permutation.
*/
class Solution {
    private int getDecreasePoint(int[] arr) {
        int ret = -1;
        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i] < arr[i+1]) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    private int getLargerThen(int[] arr, int src) {
        int ret = -1;
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] > src) {
                ret = i;
                break;
            }
        }
        return ret;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    private void reverse(int[] arr, int s) {
        for (int l=s, r=arr.length-1; l < r; ++l, --r) {
            swap(arr, l, r);
        }
    }

    public void nextPermutation(int[] nums) {
        int l = getDecreasePoint(nums);
        if (l >= 0) {
            int r = getLargerThen(nums, nums[l]);
            swap(nums, l, r);
        }        
        reverse(nums, l+1);
    }
}