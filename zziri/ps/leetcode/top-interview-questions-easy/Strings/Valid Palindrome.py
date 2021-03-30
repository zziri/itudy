class Solution:
    def isPalindrome(self, s: str) -> bool:
        def convert(s):
            ret = list()
            for c in s:
                code = ord(c)
                if code >= ord('A') and code <= ord('Z'):
                    ret.append(chr(code+32))
                elif (code >= ord('a') and code <= ord('z')) or (code >= ord('0') and code <= ord('9')):
                    ret.append(chr(code))
            return ''.join(ret)
        s = convert(s)
        l, r = 0, len(s)-1
        while l < r:
            if s[l] != s[r]:
                return False
            l, r = l+1, r-1
        return True
