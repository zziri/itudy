// MEMO : 더 빠른 방법 찾아보고, 다시 복귀한 것 축하!!

// Runtime: 2 ms, faster than 69.14% of Java online submissions for Letter Combinations of a Phone Number.
// Memory Usage: 41.9 MB, less than 85.44% of Java online submissions for Letter Combinations of a Phone Number.

class Solution {
    private Map<Integer, String> ref;
    private List<String> result;
    
    Solution() {
        ref = new HashMap<>();
        ref.put(2, "abc");
        ref.put(3, "def");
        ref.put(4, "ghi");
        ref.put(5, "jkl");
        ref.put(6, "mno");
        ref.put(7, "pqrs");
        ref.put(8, "tuv");
        ref.put(9, "wxyz");
        result = new ArrayList<>();
    }
    
    private void recur(List<Integer> keys, int depth, StringBuilder builder) {
        if (depth == keys.size()) {
            if (!builder.isEmpty())
                result.add(builder.toString());
            return;
        }
        
        String letters = ref.get(keys.get(depth));
        for (int i=0; i<letters.length(); i++) {
            Character ch = letters.charAt(i);
            builder.append(ch);
            recur(keys, depth+1, builder);
            builder.setLength(builder.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<Integer> keys = new ArrayList<>();
        for (int i=0; i<digits.length(); i++) {
            char c = digits.charAt(i);
            keys.add(Character.getNumericValue(c));
        }
        recur(keys, 0, new StringBuilder());
        return result;
    }
}
