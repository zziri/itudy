class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var n : nums) {
            if (map.containsKey(n))
                return true;
            else
                map.put(n, 1);
        }
        return false;
    }
}
