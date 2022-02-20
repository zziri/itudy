// MEMO : heap 으로 푸는게 더 좋을듯

// Runtime: 86 ms, faster than 5.06% of Java online submissions for Sort List.
// Memory Usage: 64.3 MB, less than 5.10% of Java online submissions for Sort List.

class Solution {
    public ListNode sortList(ListNode head) {
        Map<Integer, List<ListNode>> map = new TreeMap<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (!map.containsKey(node.val)) {
                map.put(node.val, new ArrayList<>());
            }
            map.get(node.val).add(node);
        }
        
        ListNode pre = null, ret = null;
        
        for (Map.Entry<Integer, List<ListNode>> entry : map.entrySet()) {
            for (ListNode node : entry.getValue()) {
                if (pre == null) {
                    pre = node;
                    ret = node;
                } else {
                    pre.next = node;
                    node.next = null;
                    pre = node;
                }
            }
        }
        
        return ret;
    }
}
