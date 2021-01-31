class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        ret = 0
        if (dividend >= 0 and divisor >=0) or (dividend < 0 and divisor < 0):
            while abs(dividend) >= abs(divisor):
                dividend -= divisor
                ret += 1
        else:
            while abs(dividend) >= abs(divisor):
                dividend += divisor
                ret -= 1
        return ret

