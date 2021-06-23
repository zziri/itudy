// MEMO : 굳이 최적화하지 않고 Set,Map 써도 충분하다

// Runtime: 1 ms, faster than 70.39% of Java online submissions for Jewels and Stones.
// Memory Usage: 37.6 MB, less than 37.57% of Java online submissions for Jewels and Stones.
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int ret = 0;
        Set<Character> jewelSet = new HashSet<>();
        for (int i=0; i<jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }
        for (int i=0; i<stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i)))
                ++ret;
        }
        return ret;
    }
}
