button = [[], [], ['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i'], ['j', 'k', 'l'], ['m', 'n', 'o'], ['p', 'q', 'r', 's'], ['t', 'u', 'v'], ['w', 'x', 'y', 'z']]

class Solution:
    def solve(self, digits, depth, res, temp):
        if depth == len(digits):
            res.append(temp)
            return None
        
        idx = int(digits[depth])
        for digit in button[idx]:
            self.solve(digits, depth+1, res, temp+digit)
    
    
    def letterCombinations(self, digits: str) -> List[str]:
        ret = list()
        if digits:
            self.solve(digits, 0, ret, "")
        return ret
