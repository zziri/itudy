// MEMO : 주기적으로 풀어야하는 문제인듯...

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> picked = new HashSet<>();
        int l = 0;
        int ret = 0;
        for (int r=0; r<s.length(); r++) {
            Character c = s.charAt(r);
            while (picked.contains(c)) {
                picked.remove(s.charAt(l++));
            }
            picked.add(c);
            ret = Math.max(ret, picked.size());
        }
        
        ret = Math.max(ret, picked.size());
        
        return ret;
    }
}