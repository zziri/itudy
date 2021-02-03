limit = 2**31 - 1

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        import math
        
        minus = False
        
        if dividend == 0:
            return 0
        
        if (dividend < 0 and divisor >= 0) or (dividend >= 0 and divisor < 0):
            minus = True
            dividend = abs(dividend)
            divisor = abs(divisor)
        elif dividend < 0 and divisor < 0:
            dividend = -dividend
            divisor = -divisor
        
        ret = int(math.exp(math.log(dividend) - math.log(divisor)))
        
        ret = ret if not minus else -ret
                
        if ret < -limit-1:
            ret = -limit-1
        elif ret > limit:
            ret = limit
            
        return ret
