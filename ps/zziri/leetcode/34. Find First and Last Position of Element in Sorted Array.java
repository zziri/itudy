class Solution {
    private int binarySearch(int[] arr, int target) {
        if (arr.length == 0 || arr == null)
            return -1;

        int l = 0, r = arr.length-1;
        
        while (l <= r) {
            int mid = (l+r)/2;
            
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                l = mid+1;
            else
                r = mid - 1;
        }
        
        return -1;
    }
    
    private int[] findFirstLast(int[] arr, int index) {
        int[] ret = new int[2];
        if (index == -1) {
            ret[0] = ret[1] = -1;
        } else {
            int l, r;
            for (l=index; l > 0 && arr[l] == arr[index]; l--) {}
            if (arr[index] != arr[l])   l+=1;
            
            for (r=index; r < arr.length-1 && arr[r] == arr[index]; r++) {}
            if (arr[index] != arr[r]) r-=1;
            
            ret[0] = l;
            ret[1] = r;
        }
        return ret;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        return findFirstLast(nums, index);
    }
}
