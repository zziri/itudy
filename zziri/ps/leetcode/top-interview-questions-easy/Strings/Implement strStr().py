class Solution:
    def getHashCode(self, s="", start=None, end=None):
        if not start and not end:
            start, end = 0, len(s)
        ret = 0
        for i in range(start, end):
            ret += ord(s[i])
        return ret
    
    def stringCompare(self, src, dst, start, end):
        idx = 0
        for i in range(start, end):
            if src[i] != dst[idx]:
                return False
            idx += 1
        return True
    
    def updateHash(self, code, s, start, end):
        return code - ord(s[start]) + ord(s[end])
    
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        
        targetHash = self.getHashCode(needle)
        curHash = self.getHashCode(haystack, 0, min(len(needle), len(haystack)))
        ret = -1
        
        for i in range(len(haystack)-len(needle)+1):
            if i > 0:
                curHash = self.updateHash(curHash, haystack, i-1, i+len(needle)-1)
            if curHash == targetHash:
                if self.stringCompare(haystack, needle, i, i+len(needle)):
                    ret = i
                    break
                    
        return ret
