class Solution {
    private ListNode addFront(ListNode head, ListNode node) {
        if (head == null) {
            node.next = null;
            return node;
        }
        node.next = head;
        head = node;
        return head;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode ret = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ret = addFront(ret, cur);
            cur = next;
        }
        return ret;
    }
}
