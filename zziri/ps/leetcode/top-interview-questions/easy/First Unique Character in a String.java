class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
