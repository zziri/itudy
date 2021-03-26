// MEMO : 단순 구현의 시간 복잡도가 O(N)이면 Set 혹은 Map을 쓰는게 더 느릴수도 있다!

// 1msec, 98.01%
public class Solution {
    private int getSize(ListNode ptr) {
        int ret = 0;
        while (ptr != null) {
            ret += 1;
            ptr = ptr.next;
        }
        return ret;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA), sizeB = getSize(headB);
        
        ListNode ptrA = headA, ptrB = headB;
        while (sizeA < sizeB) {
            sizeB -= 1;
            ptrB = ptrB.next;
        }
        
        while (sizeA > sizeB) {
            sizeA -= 1;
            ptrA = ptrA.next;
        }
        
        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                break;
            } else {
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
        }
        
        return ptrA;
    }
}


// 7msec, 24.18%
/*
public class Solution {
    private Set<ListNode> set = new HashSet<>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        for (ListNode ptr = headA; ptr != null; ptr = ptr.next) {
            set.add(ptr);
        }
        
        for (ListNode ptr = headB; ptr != null; ptr = ptr.next) {
            if (set.contains(ptr)) {
                return ptr;
            }
        }
        return null;
    }
}
*/