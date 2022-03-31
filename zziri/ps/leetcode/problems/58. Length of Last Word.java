// MEMO : 성능 개선 성공..!

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
// Memory Usage: 42.5 MB, less than 25.02% of Java online submissions for Length of Last Word.
class Solution {
    public int lengthOfLastWord(String s) {
        int l = -1, r = -1;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                r = i;
                break;
            }
        }
        if (r < 0) {
            return 0;
        }
        
        for (int i=r; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                l = i;
                break;
            }
        }
        if (l < 0) {
            return r+1;
        }
        
        return r - l;
    }
}
