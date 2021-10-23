// MEMO : 해답 보자 이렇게 푸는게 아닌듯

// Runtime: 38 ms, faster than 5.16% of Java online submissions for Largest Number.
// Memory Usage: 39.4 MB, less than 45.80% of Java online submissions for Largest Number.

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
            String lr = String.format("%s%s", l, r);
            String rl = String.format("%s%s", r, l);
            return rl.compareTo(lr);
        });
        
        StringBuilder ret = new StringBuilder();
        
        for (int i=0; i<list.size(); i++) {
            ret.append(list.get(i));
        }
        
        return ret.toString();
    }
}
