// MEMO : 기초라고 무시하고 안 푸는 실수 하지말자 원형 큐도 실수하는 상태


// Runtime: 4 ms, faster than 97.81% of Java online submissions for Design Circular Queue.
// Memory Usage: 39.7 MB, less than 30.07% of Java online submissions for Design Circular Queue.
class MyCircularQueue {
    private int[] q;
    private int head;
    private int tail;
    private int count;

    public MyCircularQueue(int k) {
        q = new int[k];
        count = head = tail = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (count > 0)
            tail = (tail+1)%q.length;
        q[tail] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())
            return false;
        if (count > 1)
            head = (head+1)%q.length;
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty())
            return -1;
        return q[head];
    }
    
    public int Rear() {
        if (isEmpty())
            return -1;
        return q[tail];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == q.length;
    }
}
