class TheList {
    public ListNode head;
    public ListNode tail;
    public TheList() { this.head = null; this.tail = null; }
    public void append(ListNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        TheList list = new TheList();
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next = l1.next;
                list.append(l1);
                l1 = next;
            } else {
                ListNode next = l2.next;
                list.append(l2);
                l2 = next;
            }
        }
        if (l1 != null)
            list.append(l1);
        if (l2 != null)
            list.append(l2);
        return list.head;
    }
}
