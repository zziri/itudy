// MEMO : 너어무 복잡한데...? 성능도 안좋다..

class Solution {
    private String zip(String str) {
        Map<Character, Integer> pool = new TreeMap<>();
        for (int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            pool.put(c, pool.getOrDefault(c, 0) + 1);
        }
        StringBuilder ret = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : pool.entrySet()) {
            ret.append(entry.getKey()).append(entry.getValue());
        }
        return ret.toString();
    }

    private List<List<String>> toStringList(Map<String, List<String>> zippedMap) {
        List<List<String>> ret = new ArrayList<>();
        int index = 0;
        for (Map.Entry<String, List<String>> entry : zippedMap.entrySet()) {
            ret.add(new ArrayList<>());
            for (String str : entry.getValue()) {
                ret.get(index).add(str);
            }
            index += 1;
        }
        return ret;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> zippedMap = new HashMap<>();
        for (String str : strs) {
            String zippedStr = zip(str);
            if (!zippedMap.containsKey(zippedStr)) {
                zippedMap.put(zippedStr, new ArrayList<>());
            }
            zippedMap.get(zippedStr).add(str);
        }
        return toStringList(zippedMap);
    }
}
