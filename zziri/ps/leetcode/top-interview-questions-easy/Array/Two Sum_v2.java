class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ret = {0, 0};
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i=0; i<nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value) && map.get(value) != i) {
                ret[0] = map.get(value);
                ret[1] = i;
                break;
            }
        }
        
        return ret;
    }
}
