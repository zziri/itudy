// MEMO : 더 빠르게 최적화 하는 방법도 배워보자

// Runtime: 12 ms, faster than 24.12% of Java online submissions for Evaluate Reverse Polish Notation.
// Memory Usage: 41.4 MB, less than 21.03% of Java online submissions for Evaluate Reverse Polish Notation.

class Solution {
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*");
    }
    
    private int operating(int left, int right, String operator) {
        if (operator.equals("+")) {
            return left + right;
        } else if (operator.equals("-")) {
            return left - right;
        } else if (operator.equals("/")) {
            return left / right;
        } else if (operator.equals("*")) {
            return left * right;
        } else {
            throw new RuntimeException("operating error");
        }
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int right = s.pop();
                int left = s.pop();
                int result = operating(left, right, token);
                s.push(result);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }
}
