class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ret = set()
        nums.sort()

        for i, base in enumerate(nums):
            if i > 0 and nums[i] == nums[i-1]:
                continue

            l, r = i+1, len(nums)-1

            while l < r:
                if l == i:
                    l += 1
                    continue
                if r == i:
                    r -= 1
                    continue
                
                val = nums[l] + base + nums[r]
                if val < 0:
                    l += 1
                elif val > 0:
                    r -= 1
                else:
                    ret.add((nums[l], base, nums[r]))
                    l += 1

        return list(ret)
