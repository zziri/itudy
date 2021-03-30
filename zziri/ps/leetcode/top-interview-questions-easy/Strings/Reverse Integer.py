limit = 2**31

class Solution:
    def reverse(self, x: int) -> int:
        minus = False if x > 0 else True
        if minus:
            x = -x
        
        ret = 0
        while x > 0:
            ret *= 10
            ret += x % 10
            x = int(x/10)
        
        if minus:
            ret = -ret
            if ret < -limit:
                ret = 0
        else:
            if ret > limit-1:
                ret = 0
        
        return ret
