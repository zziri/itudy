// MEMO : String.format 은 상당히 느리다 차라리 + 연산이 낫다

// Runtime: 5 ms, faster than 79.08% of Java online submissions for Largest Number.
// Memory Usage: 38.1 MB, less than 97.79% of Java online submissions for Largest Number.

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        boolean isAllZero = true;
        for (int num : nums) {
            if (isAllZero && num > 0)
                isAllZero = false;
            list.add(Integer.toString(num));
        }
        
        if (isAllZero)
            return "0";
        
        list.sort((l, r) -> {
            String lr = l + r;
            String rl = r + l;
            return rl.compareTo(lr);
        });
        
        StringBuilder ret = new StringBuilder();
        
        for (int i=0; i<list.size(); i++) {
            ret.append(list.get(i));
        }
        
        return ret.toString();
    }
}
