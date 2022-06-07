// MEMO : 너무 복잡한데..

// Runtime: 9 ms, faster than 46.35% of Java online submissions for Count and Say.
// Memory Usage: 45.5 MB, less than 25.19% of Java online submissions for Count and Say.

class Solution {
    public String countAndSay(int n) {
        String ret = null;
        for (int i=1; i<=n; i++) {
            ret = countAndSay(ret);
        }
        return ret;
    }

    private String countAndSay(String numbers) {
        if (numbers == null) {
            return "1";
        }
        StringBuilder ret = new StringBuilder();
        Character pre = null;
        int count = 0;
        for (int i=0; i<numbers.length(); i++) {
            Character c = numbers.charAt(i);
            if (pre == null) {
                pre = c;
                count += 1;
                continue;
            }
            if (!pre.equals(c)) {
                ret.append(String.valueOf(count));
                ret.append(pre);
                pre = c;
                count = 1;
            } else {
                count += 1;
            }
        }
        ret.append(String.valueOf(count));
        ret.append(pre);
        return ret.toString();
    }
}
