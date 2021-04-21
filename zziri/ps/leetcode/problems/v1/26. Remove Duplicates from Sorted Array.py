class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        s = set(nums)
        nums.clear()
        for n in sorted(s):
            nums.append(n)
        return len(s)
