// MEMO : 메모리를 쓰더라도 일단 풀고 나서 고민하자

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
    Memory Usage: 36.4 MB, less than 80.74% of Java online submissions for Swap Nodes in Pairs.
*/
class Solution {
    private List<ListNode> createList(ListNode head) {
        List<ListNode> ret = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            ret.add(node);
        }
        return ret;
    }
    
    private void swap(List<ListNode> list) {
        for (int i=0; i<list.size()-1; i+=2) {
            ListNode left = list.get(i);
            ListNode right = list.get(i+1);
            list.set(i, right);
            list.set(i+1, left);
        }
    }
    
    private ListNode createLinkedList(List<ListNode> list) {
        if (list.isEmpty())
            return null;
        ListNode head = list.get(0), tail = list.get(0);
        for (int i=1; i<list.size(); i++) {
            tail.next = list.get(i);
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
    
    public ListNode swapPairs(ListNode head) {
        List<ListNode> list = createList(head);
        swap(list);
        return createLinkedList(list);
    }
}
