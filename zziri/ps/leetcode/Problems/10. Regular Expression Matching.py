import re
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        pat = re.compile(p)
        match = re.search(pat, s)
        if not match:
            return False
        else:
            if s == s[match.start(): match.end()]:
                return True
            else:
                return False

