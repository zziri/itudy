// MEMO : 이분탐색법으로 찾아야하지 않을까

// Runtime: 38 ms, faster than 5.51% of Java online submissions for Integer to Roman.
// Memory Usage: 45.3 MB, less than 5.12% of Java online submissions for Integer to Roman.

class Solution {
    static class Roman {
        private Map<Integer, String> valueToSymbol = new TreeMap<>((l, r) -> r - l);;
        public Roman() {
            valueToSymbol.put(1, "I");
            valueToSymbol.put(4, "IV");
            valueToSymbol.put(5, "V");
            valueToSymbol.put(9, "IX");
            valueToSymbol.put(10, "X");
            valueToSymbol.put(40, "XL");
            valueToSymbol.put(50, "L");
            valueToSymbol.put(90, "XC");
            valueToSymbol.put(100, "C");
            valueToSymbol.put(400, "CD");
            valueToSymbol.put(500, "D");
            valueToSymbol.put(900, "CM");
            valueToSymbol.put(1000, "M");
        }
        
        public int getLargestValue(int n) {
            for (int value : valueToSymbol.keySet()) {
                if (n >= value) {
                    return value;
                }
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
