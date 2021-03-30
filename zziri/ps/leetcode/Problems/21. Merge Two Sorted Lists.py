class Solution:
    def __init__(self):
        self.ret = None
        self.tail = None
    
    def append(self, val):
        if not self.ret and not self.tail:
            self.ret = ListNode(val, None)
            self.tail = self.ret
            return None
        
        newnode = ListNode(val, None)
        self.tail.next = newnode
        self.tail = newnode
        
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                self.append(l1.val)
                l1 = l1.next
            else:
                self.append(l2.val)
                l2 = l2.next
        
        while l1 is not None:
            self.append(l1.val)
            l1 = l1.next
        
        while l2 is not None:
            self.append(l2.val)
            l2 = l2.next
            
        return self.ret
