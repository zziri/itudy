// MEMO : 클래스를 만드는게 편할 때도 많다

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
    Memory Usage: 38.5 MB, less than 57.42% of Java online submissions for Odd Even Linked List.
*/
class CList {
    ListNode head;
    ListNode tail;
    void add(ListNode node) {
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }
        
    void append(CList list) {
        tail.next = list.head;
        tail = list.tail;
    }
    void clear() { head = tail = null; }
}

class Solution {
    private static CList odd = new CList();
    private static CList even = new CList();
    
    public ListNode oddEvenList(ListNode node) {
        if (node == null || node.next == null)
            return node;
        odd.clear(); even.clear();
        for (int i=1; node != null; i++) {
            if (i % 2 != 0) {
                odd.add(node);
            } else {
                even.add(node);
            }
            node = node.next;
        }
        even.tail.next = null;
        odd.append(even);
        return odd.head;
    }
}
