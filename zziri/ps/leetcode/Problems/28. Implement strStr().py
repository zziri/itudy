class Solution:    
    def strStr(self, haystack: str, needle: str) -> int:
        if not needle:
            return 0
        
        patternHash = 0
        parentHash = 0
        for i, ch in enumerate(needle):
            patternHash = patternHash + ord(ch)
        
        for i, ch in enumerate(haystack):
            if i > len(haystack) - len(needle):
                break
            if i == 0:
                weight = 1
                for j in range(len(needle)):
                    parentHash = parentHash + ord(haystack[j])
            else:
                parentHash = parentHash - ord(haystack[i-1])
                parentHash = parentHash + ord(haystack[i+len(needle)-1])
            if parentHash == patternHash:
                if haystack[i:i+len(needle)] == needle:
                    return i
                
        
        return -1
