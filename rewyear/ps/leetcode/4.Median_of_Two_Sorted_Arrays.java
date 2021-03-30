class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int mid = (len1 + len2) / 2;
        
        int[] merged = new int[len1 + len2];
        
        System.arraycopy(nums1,0,merged,0,len1);
        System.arraycopy(nums2,0,merged,len1,len2);
        
        Arrays.sort(merged);
        
        if(merged.length % 2 == 0)
            return (merged[mid] + merged[mid-1])/2.0;
        else
            return merged[mid];
        
    }
}
