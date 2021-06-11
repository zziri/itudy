// MEMO : 주어진 데이터에서 상승세를 알아낼 땐 stack 을 이용하자!!

/*
    Runtime: 33 ms, faster than 28.18% of Java online submissions for Daily Temperatures.
    Memory Usage: 49.2 MB, less than 17.41% of Java online submissions for Daily Temperatures.
*/
class Pair {
    public int t;
    public int i;
    Pair(int t, int i) { this.t = t; this.i = i; }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().t < temperatures[i]) {
                Pair pair = stack.pop();
                ret[pair.i] = i - pair.i;
            }
            stack.push(new Pair(temperatures[i], i));
        }
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            ret[pair.i] = 0;
        }
        return ret;
    }
}
