// MEMO : 다시 풀어봤는데, 이번에는 간결하고 성능도 괜찮은듯

class Solution {
    private String getSortedString(String origin) {
        char[] array = origin.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    
    private List<List<String>> getList(Map<String, List<String>> map) {
        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ret.add(entry.getValue());
        }
        return ret;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sorted = getSortedString(str);
            if (!map.containsKey(sorted))
                map.put(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return getList(map);
    }
}
