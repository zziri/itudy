class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        mark = int(1e4+1)
        ptr = 0
        for i in range(len(nums)):
            if mark != nums[i]:
                mark = nums[i]
                nums[ptr] = mark
                ptr += 1
        
        return ptr
