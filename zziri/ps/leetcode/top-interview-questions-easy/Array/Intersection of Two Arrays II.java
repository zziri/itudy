class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();
        
        for (int n : nums1)
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        
        for (int n : nums2)
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        
        for (Integer key : map1.keySet()) {
            if(map2.containsKey(key)) {
                res.put(key, map1.get(key) > map2.get(key) ? map2.get(key) : map1.get(key));
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        int idx=0;
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            for (int i=0; i<entry.getValue(); i++) {
                ret.add(entry.getKey());
            }
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
}
