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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = 0;
        int other = 0;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode pNode = null;
        ListNode head = null;
        
        // first node sum
        val = (p1.val + p2.val + other)%10;
        other = (p1.val + p2.val + other)/10; 
        head = new ListNode(val,null);
        
        pNode = head;
        p1=p1.next;
        p2=p2.next;
        while(p1 != null && p2 != null){
            val = (p1.val + p2.val + other)%10;
            other = (p1.val + p2.val + other)/10; 
            
            pNode.next = new ListNode(val,null);
            pNode = pNode.next;
            p1=p1.next;
            p2=p2.next;
        }
        
        while(p1 != null){
            val = (p1.val + other)%10;
            other = (p1.val + other)/10; 
            pNode.next = new ListNode(val,null);
            pNode = pNode.next;
            p1 = p1.next;
                
        }
        
        while(p2 != null){
            val = (p2.val + other)%10;
            other = (p2.val + other)/10; 
            pNode.next = new ListNode(val,null);
            pNode = pNode.next;
            p2 = p2.next;
                
        }
        
        if(other != 0)
            pNode.next = new ListNode(other,null);
        
        return head;
    }
}
