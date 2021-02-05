class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if nums[0] == target:
            return 0
        elif nums[0] > target:
            for i in range(len(nums)-1, -1, -1):
                if nums[i] == target:
                    return i
                if i == 0:
                    return -1
                else:
                    if nums[i-1] > nums[i]:
                        return -1
        else:
            for i, n in enumerate(nums):
                if n == target:
                    return i
                if i == len(nums)-1:
                    return -1
                else:
                    if nums[i+1] < n:
                        return -1
