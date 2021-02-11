class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (var n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ret = entry.getKey().intValue();
                break;
            }
        }
        return ret;
    }
}
