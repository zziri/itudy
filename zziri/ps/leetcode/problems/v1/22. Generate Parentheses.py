class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        
        def valid(s):
            stack = list()
            for ch in s:
                if ch == '(':
                    stack.append(ch)
                else:
                    if len(stack) != 0 and stack[len(stack)-1] == '(':
                        stack.pop()
                    else:
                        return False
            
            return len(stack) == 0
        
        def recur(temp, res, limit, depth):
            if depth == limit:
                if valid(temp):
                    res.append(temp)
                return None
            
            recur(temp+'(', res, limit, depth+1)
            recur(temp+')', res, limit, depth+1)
    
        ret = list()

        recur('(', ret, n*2, 1)

        return ret

