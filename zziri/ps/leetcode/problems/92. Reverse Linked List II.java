// MEMO : 링크드리스트 문제도 열심히

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
    Memory Usage: 38.7 MB, less than 5.25% of Java online submissions for Reverse Linked List II.
*/
class Solution {
    private ListNode front;
    private int left;
    private int right;
    private int mid;
    
    private void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void reverse(int depth, ListNode current) {
        if (current == null)
            return;
        if (depth == left && front == null)
            front = current;
        
        reverse(depth+1, current.next);
        if (depth > mid && depth <= right) {
            swap(front, current);
            front = front.next;
        }
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.left = left;
        this.right = right;
        this.mid = (left+right)/2;
        reverse(1, head);
        return head;
    }
}
