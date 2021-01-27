# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if not head:
            return head
        
        d, idx, cur = dict(), 1, head
        
        while cur != None:
            d[idx] = cur
            idx += 1
            cur = cur.next
        
        size = idx-1
        target_index = idx-n
        if target_index == 1:
            if size == 1:
                return None
            else:
                return d[2]
        elif target_index == size:
            d[target_index-1].next = None
        else:
            d[target_index-1].next = d[target_index+1]
        
        return head
