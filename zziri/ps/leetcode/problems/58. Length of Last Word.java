// MEMO : 너무 느리다 뒤에서 순회하도록 수정하자

// Runtime: 4 ms, faster than 9.09% of Java online submissions for Length of Last Word.
// Memory Usage: 42.7 MB, less than 17.89% of Java online submissions for Length of Last Word.
class Solution {
    public int lengthOfLastWord(String s) {
        int ret = 0, i = 0, length = 0;
        while (i <= s.length()) {
            if (i == s.length() || s.charAt(i) == ' ') {
                ret = length > 0 ? length : ret;
                length = 0;
            } else {
                length += 1;
            }
            i += 1;
        }
        return ret;
    }
}
