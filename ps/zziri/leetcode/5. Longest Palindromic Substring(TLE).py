class Solution:
    def is_palindrome(self, s, start, l):
        if l == 1:
            return True
        l, r = start, start+l-1
        while l < r:
            if s[l] != s[r]:
                return False
            else:
                l += 1
                r -= 1
        return True
    
    def get_palindrome(self, s, l):
        for start in range(len(s)-l+1):
            if self.is_palindrome(s, start, l):
                return s[start:start+l]
        return None
    
    def longestPalindrome(self, s: str) -> str:
        for l in range(len(s), 0, -1):
            ret = self.get_palindrome(s, l)
            if ret:
                return ret
