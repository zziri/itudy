class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        if not strs or not strs[0]:
            return ''
        
        ret = ''
        
        for size in reversed(range(1, len(strs[0])+1)):
            substring = strs[0][:size]
            for s in strs:
                if substring != s[:size]:
                    substring = None
                    break
            
            if substring:
                ret = substring
                break
        
        return ret
