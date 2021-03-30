// MEMO : 현재 상태를 스택에 저장할 수도 있다..!

class Pair {
    public int min;
    public int val;
    Pair() { this.min = 0; this.val = 0; }
    Pair(int min, int val) {
        this.min = min;
        this.val = val;
    }
}

class MinStack {
    private LinkedList<Pair> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        int minValue;
        if (stack.isEmpty()) {
            minValue = Integer.MAX_VALUE;
        } else {
            minValue = stack.peek().min;
        }
        stack.push(new Pair(Math.min(minValue, val), val));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
