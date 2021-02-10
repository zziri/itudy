class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ret = 0
        for i in range(len(prices)):
            if i == 0:
                continue
            diff = prices[i] - prices[i-1]
            ret += diff if diff > 0 else 0
        
        return ret
