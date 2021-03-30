class Solution {
    private ListNode ptr;
    private boolean result;

    private ListNode recur(ListNode cur) {
        if (cur.next == null)
            return cur;
        
        ListNode node = recur(cur.next);
        if (node.val != ptr.val)
            result = false;
        
        ptr = ptr.next;

        return cur;
    }

    public boolean isPalindrome(ListNode head) {
        this.ptr = head;
        this.result = true;
        this.recur(head);
        
        return this.result;
    }
}
