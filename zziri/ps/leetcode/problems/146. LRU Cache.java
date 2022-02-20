// MEMO : LinkedHashMap을 활용해도 순서를 기억할 수 있음

// Runtime: 51 ms, faster than 56.96% of Java online submissions for LRU Cache.
// Memory Usage: 118.1 MB, less than 48.04% of Java online submissions for LRU Cache.

class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;
    
    private void removeFirst(Map<Integer, Integer> map) {
        for (int key : map.keySet()) {
            map.remove(key);
            break;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        int ret = -1;
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            ret = value;
        }
        return ret;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() == capacity) {
            removeFirst(cache);
        }
        cache.put(key, value);
    }
}
