class Solution:
    def getPalindromeLen(self, s, l, r):
        while l >= 0 and r < len(s) and s[l] == s[r]:
            l -= 1
            r += 1
        return r-l-1
    
    def longestPalindrome(self, s: str) -> str:
        ret = ""
        for i in range(len(s)):
            len1 = self.getPalindromeLen(s, i, i)
            len2 = self.getPalindromeLen(s, i, i+1)
            if len1 > len2:
                if len(ret) < len1:
                    start = i - int(len1/2)
                    end = start + len1
                    ret = s[start:end]
            else:
                if len(ret) < len2:
                    end = i + int(len2/2) + 1
                    start = end - len2
                    ret = s[start:end]
        return ret
