public class Solution {
    final static int clear = 100001;

    public boolean hasCycle(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            if (ptr.val == clear)
                return true;
            
            ptr.val = clear;
            ptr = ptr.next;
        }

        return false;
    }
}
