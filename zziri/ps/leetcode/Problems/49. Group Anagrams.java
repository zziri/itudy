// MEMO : !map.containsKey(key) 보다 map.get(key) == null 이 더 빠르다, 성능 측정 해보자

// 5 ms, 98.75 %
class Solution {
    private String makeKey(String str) {
        char tmp[] = str.toCharArray();
        Arrays.sort(tmp);
        return String.valueOf(tmp);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            String key = makeKey(str);
            if (map.get(key) == null)
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}


// 6 ms, 79.99 %
/*
class Solution {
    private String makeKey(String str) {
        char tmp[] = str.toCharArray();
        Arrays.sort(tmp);
        return String.valueOf(tmp);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        for (String str : strs) {
            String key = makeKey(str);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
*/