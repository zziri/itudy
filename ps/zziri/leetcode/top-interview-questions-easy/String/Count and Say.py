class Solution:
    def create(self, s):
        ret, base, cnt = list(), s[0], 0
        
        for c in s:
            if base == c:
                cnt += 1
            else:
                ret.append(str(cnt)); ret.append(base)
                base, cnt = c, 1

        ret.append(str(cnt)); ret.append(base)
        return ''.join(ret)
    
    def countAndSay(self, n: int) -> str:        
        pre, ret = "1", "1"
        
        for i in range(2, n+1):
            ret = self.create(pre)
            pre = ret

        return ret
