
def is_num(c):
    return c >= '0' and c <= '9'

l, h = -(2**31), 2**31-1

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        if not s:
            return 0
        minus = False
        if s[0] == '-':
            minus = True
            s = s[1:]
        elif s[0] == '+':
            s = s[1:]
        if not s or not is_num(s[0]):
            return 0
        ret = 0
        for c in s:
            if not is_num(c):
                break
            ret *= 10
            ret += ord(c)-ord('0')
        ret = -ret if minus else ret
        ret = l if ret < l else ret
        ret = h if ret > h else ret
        
        return ret
