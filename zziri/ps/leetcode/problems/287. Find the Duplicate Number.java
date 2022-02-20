// MEMO : 토끼와 거북이 알고리즘 참고해서 한번 더 풀이하자

/*
    Runtime: 21 ms, faster than 10.72% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 51.6 MB, less than 15.05% of Java online submissions for Find the Duplicate Number.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (int n : nums) {
            if (set.contains(n)) {
                ret = n;
                break;
            }
            set.add(n);
        }
        return ret;
    }
}
