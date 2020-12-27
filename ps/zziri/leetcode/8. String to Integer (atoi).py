import re

class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()
        if not s:
            return 0
        if s[0] >= 'a' and s[0] <= 'z':
           return 0
        if s[0] == '.':
            return 0
        if s[0] == '+' or s[0] == '-':
            if len(s) < 2:
                return 0
            if s[1] < '0' or s[1] > '9':
                return 0
        if s[0] == '+':
            s = s[1:]
        
        p = re.compile('^\-?\d*')
        match = re.search(p, s)
        if not match:
            return 0
        s = s[match.start():match.end()]

        ret = int(s)
        if ret > 2**31-1:
            ret = 2**31-1
        if ret < -2**31:
            ret = -2**31
        
        return ret
