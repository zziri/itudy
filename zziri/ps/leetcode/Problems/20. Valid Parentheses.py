class Solution:
    def isValid(self, s: str) -> bool:
        stack = list()
        for ch in s:
            if ch == '(':
                stack.append(')')
            elif ch == '[':
                stack.append(']')
            elif ch == '{':
                stack.append('}')
            else:
                if len(stack) == 0:
                    return False
                temp = stack.pop()
                if temp != ch:
                    return False
        return True if len(stack) == 0 else False
