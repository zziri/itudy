// MEMO : 간단하게 최적화 했지만 그래도 이분탐색은 해보는게 좋을 듯

// Runtime: 7 ms, faster than 47.28% of Java online submissions for Integer to Roman.
// Memory Usage: 38.8 MB, less than 58.99% of Java online submissions for Integer to Roman.

class Solution {
    static class Roman {
        private Map<Integer, String> valueToSymbol = new LinkedHashMap<>();
        private int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        private String[] symbols = {
            "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
        };
        
        public Roman() {
            for (int i=values.length-1; i>=0; i--) {
                valueToSymbol.put(values[i], symbols[i]);
            }
        }
        
        public int getLargestValue(int target) {
            for (int i=values.length-1; i>=0; i--) {
                if (target >= values[i])
                    return values[i];
            }
            return 1;
        }
        
        public String getSymbol(int value) {
            return valueToSymbol.get(value);
        }
    }
    
    public String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        Roman roman = new Roman();
        while (num > 0) {
            int curValue = roman.getLargestValue(num);
            ret.append(roman.getSymbol(curValue));
            num -= curValue;
        }
        return ret.toString();
    }
}
