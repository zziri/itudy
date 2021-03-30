class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if k == 0:
            return None
        
        idx, tmp = len(nums)-k, list()
        for _ in range(len(nums)):
            tmp.append(nums[idx])
            idx = (idx+1)%len(nums)
        
        for i in range(len(nums)):
            nums[i] = tmp[i]
