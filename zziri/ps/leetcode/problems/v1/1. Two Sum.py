class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        limit = len(nums)
        for i in range(limit):
            for j in range(i+1, limit):
                if nums[i] + nums[j] == target:
                    return [i, j]
