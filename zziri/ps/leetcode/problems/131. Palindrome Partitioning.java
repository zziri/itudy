// MEMO : substring 을 수행하기 전에 검사를 먼저 하면 더 빠름! (다시 풀면 좋음)

/*
    Runtime: 39 ms, faster than 5.08% of Java online submissions for Palindrome Partitioning.
    Memory Usage: 67.4 MB, less than 14.64% of Java online submissions for Palindrome Partitioning.
*/
class Solution {
    private List<Integer> parts;
    private List<List<String>> result;
    private List<String> getList(List<Integer> parts, String s) {
        int left = 0;
        List<String> ret = new ArrayList<>();
        for (int right : parts) {
            ret.add(s.substring(left, right));
            left = right;
        }
        return ret;
    }
    
    private boolean palindrome(String str) {
        int limit = str.length()/2;
        for (int i=0; i<limit; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }
    
    private boolean palindrome(List<String> strings) {
        for (String string : strings) {
            if (!palindrome(string))
                return false;
        }
        return true;
    }
    
    private void partition(int start, int n, String s) {
        if (start > n) {
            List<String> list = getList(parts, s);
            if (palindrome(list))
                result.add(list);
        }
        
        for (int i=start; i<=n; i++) {
            parts.add(i);
            partition(i+1, n, s);
            parts.remove(parts.size()-1);
        }
    }
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        parts = new ArrayList<>();
        partition(1, s.length(), s);
        return result;
    }
}
