class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ret = "";
        boolean escape = false;
        for (int i=0; !escape; i++) {
            char temp = ' ';
            for(String str : strs) {
                if (str.length() <= i) {
                    escape = true;
                    break;
                }
                if (temp == ' ') {
                    temp = str.charAt(i);
                    continue;
                }
                if (temp != str.charAt(i)) {
                    escape = true;
                    break;
                }
            }
            if (escape && i > 0) {
                ret = strs[0].substring(0, i);
            }
        }
        return ret;
    }
}
