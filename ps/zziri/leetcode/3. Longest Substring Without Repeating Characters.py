class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = len(s)
        if l == 1:
            return 1
        elif l == 0:
            return 0
        max_len = 0
        for i in range(l-1):
            d = dict()
            for j in range(i, l):
                if d.get(s[j]):
                    max_len = max(max_len, j-i)
                    break
                else:
                    d[s[j]] = True
                if j == l-1:
                    max_len = max(max_len, j-i+1)
                    break
        return max_len
