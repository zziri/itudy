// MEMO : 토끼와 거북이 알고리즘 참고해서 최적화 가능

// Runtime: 5 ms, faster than 10.82% of Java online submissions for Linked List Cycle II.
// Memory Usage: 43 MB, less than 6.18% of Java online submissions for Linked List Cycle II.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node))
                return node;
            set.add(node);
        }
        return null;
    }
}
