class Solution {
    private ListNode getNode(int n, ListNode head) {
        ListNode ret = head;
        for(int i=0; i<n; i++)
            ret = ret.next;
        return ret;
    }
    
    private ListNode pop(ListNode prev, ListNode head) {
        prev.next = prev.next.next;
        return head;
    }
    
    private ListNode popBack(ListNode head) {
        if (head.next == null)
            return null;
        
        ListNode prev = head;
        while (prev.next.next != null)
            prev = prev.next;
        
        prev.next = null;
        return head;
    }
    
    private ListNode popFront(ListNode head) {
        if (head.next == null)
            return null;
        
        return head.next;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1)
            return popBack(head);
        
        ListNode right = getNode(n, head);
        if (right == null)
            return popFront(head);
        
        ListNode left = head;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        
        return pop(left, head);
    }
}
