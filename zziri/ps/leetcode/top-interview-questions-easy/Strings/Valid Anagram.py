class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        ds, dt = dict(), dict()
        
        for c in s:
            ds[c] = ds.get(c, 0) + 1
        
        for c in t:
            dt[c] = dt.get(c, 0) + 1
        
        if len(dt) != len(ds):
            return False
        
        for c, cnt in ds.items():
            if dt.get(c) != cnt:
                return False
            
        return True
