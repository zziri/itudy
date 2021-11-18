// MEMO : 다시 풀었는데도 기억이 안난다..

class Solution {
    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l -= 1;
            r += 1;
        }
        return r - l - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        
        int start = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            int lenOdd = expandAroundCenter(s, i, i);
            int lenEven = expandAroundCenter(s, i, i+1);
            int len = Math.max(lenOdd, lenEven);
            // System.out.println(String.format("%d: %s", i, s.substring(i-(len-1))))
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}