// MEMO : 알파벳은 26가지, 26진수와 동일!

class Solution {
    public int titleToNumber(String title) {
        int weight = 1;
        int ret = 0;

        for (int i=title.length()-1; i>=0; i--) {
            ret += (title.charAt(i)-'A'+1)*weight;
            weight *= 26;
        }

        return ret;
    }
}
