// MEMO : 정답 코드 꼭 정독하자..!

// Runtime: 6 ms, faster than 14.48% of Java online submissions for Longest Valid Parentheses.
// Memory Usage: 40 MB, less than 11.09% of Java online submissions for Longest Valid Parentheses.
class Node {
    Integer i;
    Character c;
    Node() {}
    Node(Integer i, Character c) { this.i = i; this.c = c; }
}

class Solution {
    private List<Node> getValidList(String s) {
        List<Node> ret = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            ret.add(new Node(0, c));
            if (stack.isEmpty()) {
                stack.push(new Node(i, c));
                continue;
            }
            if (stack.peek().c.equals('(') && c.equals(')')) {
                Node node = stack.pop();
                ret.get(node.i).i = 1;
                ret.get(i).i = 1;
                continue;
            }
            stack.push(new Node(i, c));
        }
        return ret;
    }
    
    private int getLongestValid(List<Node> list) {
        int ret = 0;
        int val = 0;
        for (Node node : list) {
            if (node.i == 0) {
                ret = Math.max(ret, val);
                val = 0;
            } else {
                val += 1;
            }
        }
        ret = Math.max(ret, val);
        return ret;
    }
    
    public int longestValidParentheses(String s) {
        List<Node> validList = getValidList(s);
        return getLongestValid(validList);
    }
}

