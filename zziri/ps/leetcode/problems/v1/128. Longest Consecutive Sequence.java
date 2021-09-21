// MEMO : 한번 더 풀자!!

// Runtime: 13 ms, faster than 90.28% of Java online submissions for Longest Consecutive Sequence.
// Memory Usage: 54.5 MB, less than 44.97% of Java online submissions for Longest Consecutive Sequence.

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        
        int longest = 0;
        for (int n : set) {
            if (!set.contains(n-1)) {
                int currentNumber = n;
                int length = 0;
                while (set.contains(currentNumber)) {
                    currentNumber += 1;
                    length += 1;
                }
                
                longest = Math.max(longest, length);
            }
        }
        
        return longest;
    }
}
