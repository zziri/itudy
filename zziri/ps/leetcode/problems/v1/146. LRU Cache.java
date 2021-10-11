// MEMO : LinkedHashSet을 활용하면 순서를 기억할 수 있음..!

// Runtime: 181 ms, faster than 5.03% of Java online submissions for LRU Cache.
// Memory Usage: 165.4 MB, less than 24.63% of Java online submissions for LRU Cache.

class LRUCache {
    private int cap;
    private Map<Integer, Integer> map;
    private Set<Integer> ref;
    
    private int findFirst(Set<Integer> set) {
        int ret = 0;
        for (int n : set) {
            ret = n;
            break;
        }
        return ret;
    }
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        ref = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ref.remove(key);
        ref.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ref.remove(key);
            ref.add(key);
            map.put(key, value);
            return;
        }
        if (cap == map.size()) {
            int oldKey = findFirst(ref);
            ref.remove(oldKey);
            map.remove(oldKey);
        }
        ref.add(key);
        map.put(key, value);
    }
}
