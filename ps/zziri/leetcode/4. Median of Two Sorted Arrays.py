
class Solution:
    def merge(self, arr1, arr2):
        ret = list()
        i, j = 0, 0
        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                ret.append(arr1[i])
                i += 1
            else:
                ret.append(arr2[j])
                j += 1
        if i >= len(arr1):
            ret.extend(arr2[j:])
        if j >= len(arr2):
            ret.extend(arr1[i:])
        
        return ret
    
    def get_median(self, arr):
        print(arr)
        mid = int(len(arr)/2)
        if len(arr) % 2 == 0:
            return (arr[mid] + arr[mid-1])/2
        else:
            return arr[mid]
            
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        merged = self.merge(nums1, nums2)
        return self.get_median(merged)
