// MEMO : 문제 조건을 잘 고려하자

import java.util.*;

class Solution {
    
    private String[] split(String s, int len) {
        int n = 0;
        if ((s.length() % len) == 0)
            n = (s.length()/len);
        else
            n = (s.length()/len) + 1;
        String[] ret = new String[n];
        int index = 0;
        for (int i=0; i<s.length(); i += len) {
            int start = i, end = Math.min(i+len, s.length());
            ret[index++] = s.substring(start, end);
        }
        return ret;
    }
    
    private List<Node> createStack(String[] strings) {
        List<Node> ret = new ArrayList<>();
        for (int i=0; i<strings.length; i++) {
            if (i == 0) {
                ret.add(new Node(strings[i], 1));
                continue;
            }
            Node top = ret.get(ret.size()-1);
            if (top.s.equals(strings[i])) {
                top.n += 1;
            } else {
                ret.add(new Node(strings[i], 1));
            }
        }
        return ret;
    }
    
    private int getNumberOfDigits(int n) {
        int ret = 0;
        while (n > 0) {
            ret += 1;
            n /= 10;
        }
        return ret;
    }
    
    private int getLength(String s, int len) {
        int ret = 0;
        String[] strings = split(s, len);
        List<Node> stack = createStack(strings);
        for (int i=0; i<stack.size(); i++) {
            Node node = stack.get(i);
            if (node.n == 1)
                ret += node.s.length();
            else
                ret += node.s.length() + getNumberOfDigits(node.n);
        }
        return ret;
    }
    
    public int solution(String s) {
        int answer = s.length();
        for (int len=1; len<s.length(); len++) {
            answer = Math.min(answer, getLength(s, len));
        }
        return answer;
    }
    
    static class Node {
        public String s;
        public int n;
        Node(String s, int n) { this.s = s; this.n = n; }
    }
}
