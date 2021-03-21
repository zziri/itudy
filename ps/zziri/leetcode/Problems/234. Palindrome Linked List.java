
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            arr.add(cur.val);
        }
        
        for (int l = 0, r = arr.size()-1; l < r; l++, r--) {
            if (!arr.get(l).equals(arr.get(r))) {
                return false;
            }
        }
        
        return true;
    }
}
