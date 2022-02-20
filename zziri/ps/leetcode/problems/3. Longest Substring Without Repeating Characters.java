// MEMO : 슬라이딩 윈도우 연습하자. 어렵다..

// Runtime: 6 ms, faster than 62.62% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 39.6 MB, less than 27.71% of Java online submissions for Longest Substring Without Repeating Characters.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        for (int j=0; j<s.length(); j++) {
            char ch = s.charAt(j);
            
            while (set.contains(ch)) {
                set.remove(s.charAt(i++));
            }
            
            set.add(ch);
            max = Math.max(set.size(), max);
        }
        return max;
    }
}
