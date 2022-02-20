// MEMO : Queue 로 Stack 구현하기, Stack 으로 Queue 구현하기 잊지 말자

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
    Memory Usage: 36.6 MB, less than 82.74% of Java online submissions for Implement Stack using Queues.
*/
class MyStack {
    private Queue<Integer> q;
    private Queue<Integer> tmpq;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
        tmpq = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!q.isEmpty()) {
            tmpq.add(q.poll());
        }
        q.add(x);
        while (!tmpq.isEmpty()) {
            q.add(tmpq.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
