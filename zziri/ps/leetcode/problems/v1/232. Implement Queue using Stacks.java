// MEMO : 구현은 간단한게 최고지

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Queue using Stacks.
    Memory Usage: 36.6 MB, less than 75.93% of Java online submissions for Implement Queue using Stacks.
*/
class MyQueue {
    private Stack<Integer> main;
    private Stack<Integer> buffer;

    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        buffer = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!main.isEmpty())
            buffer.push(main.pop());
        
        int ret = buffer.pop();
        
        while (!buffer.isEmpty())
            main.push(buffer.pop());
        
        return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!main.isEmpty())
            buffer.push(main.pop());
        int ret = buffer.peek();
        while (!buffer.isEmpty())
            main.push(buffer.pop());
        return ret;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty();
    }
}
