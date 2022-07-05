// MEMO : 지저분해

// Runtime: 5 ms, faster than 15.22% of Java online submissions for Add Two Numbers.
// Memory Usage: 47.6 MB, less than 62.21% of Java online submissions for Add Two Numbers.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int getSize(ListNode list) {
        int ret = 0;
        for (ListNode node=list; node != null; node = node.next) {
            ret += 1;
        }
        return ret;
    }
    
    private ListNode push(ListNode head, int value) {
        if (head == null) {
            head = createNode();
            head.val = value;
            return head;
        }
        ListNode node = head;
        for (; node.next != null; node = node.next) {}
        ListNode newnode = createNode();
        newnode.val = value;
        node.next = newnode;
        return head;
    }
    
    private ListNode createNode() {
        return new ListNode(0, null);
    }
    
    private ListNode getBig(ListNode l1, ListNode l2) {
        return getSize(l1) >= getSize(l2) ? l1 : l2;
    }
    
    private void printList(ListNode list) {
        for (ListNode node=list; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode big = getBig(l1, l2);
        ListNode little = big == l1 ? l2 : l1;
        ListNode ret = null;
        int carry = 0;
        while (little != null) {
            int value = little.val + big.val;
            if (carry > 0) {
                value += carry;
                carry = 0;
            }
            carry = (int)(value / 10);
            value = value % 10;
            ret = push(ret, value);
            // printList(ret);
            little = little.next;
            big = big.next;
        }
        
        while (big != null) {
            int value = big.val + carry;
            carry = (int)(value / 10);
            value = value % 10;
            ret = push(ret, value);
            big = big.next;
        }
        
        if (carry > 0) {
            ret = push(ret, carry);
        }
        
        return ret;
    }
}
