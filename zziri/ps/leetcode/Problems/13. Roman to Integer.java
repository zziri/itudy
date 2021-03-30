class Solution {
    public int romanToInt(String s) {
        int i = 0;
        char[] value = new char[256];
        value['I'] = 1;
        value['V'] = 5;
        value['X'] = 10;
        value['L'] = 50;
        value['C'] = 100;
        value['D'] = 500;
        value['M'] = 1000;
        
        int ret = 0;
        
        while (i < s.length()) {
            int current = 0;
            if (i + 1 < s.length() && value[s.charAt(i+1)] > value[s.charAt(i)]) {
                current = value[s.charAt(i+1)] - value[s.charAt(i)];
                i += 2;
            }
            else {
                current = value[s.charAt(i)];
                i += 1;
            }
            ret += current;
        }
        
        return ret;
    }
}
