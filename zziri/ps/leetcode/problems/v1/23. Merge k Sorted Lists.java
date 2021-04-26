// MEMO : null 체크 잘하자!!

/*
    Runtime: 4 ms, faster than 79.32% of Java online submissions for Merge k Sorted Lists.
    Memory Usage: 40.8 MB, less than 34.40% of Java online submissions for Merge k Sorted Lists.
*/
class Solution {
    private PriorityQueue<ListNode> getHeap(ListNode[] lists) {
        PriorityQueue<ListNode> ret = new PriorityQueue<>((l, r) -> l.val - r.val);
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                ret.add(lists[i]);
            }
        }
        return ret;
    }

    private ListNode getMergeList(PriorityQueue<ListNode> heap) {
        ListNode ret = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            ListNode nextHead = node.next;
            if (nextHead != null) {
                heap.add(nextHead);
            }
            node.next = null;
            if (ret == null) {
                ret = tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }
        return ret;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = getHeap(lists);
        return getMergeList(heap);
    }
}
