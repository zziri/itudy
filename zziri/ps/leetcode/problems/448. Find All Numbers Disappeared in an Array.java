// MEMO : 간단하게 풀고 고치자

// Runtime: 17 ms, faster than 32.72% of Java online submissions for Find All Numbers Disappeared in an Array.
// Memory Usage: 47.8 MB, less than 79.39% of Java online submissions for Find All Numbers Disappeared in an Array.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ret = new LinkedList<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i=1; i<=nums.length; i++) {
            if (!set.contains(i))
                ret.add(i);
        }
        return ret;
    }
}
