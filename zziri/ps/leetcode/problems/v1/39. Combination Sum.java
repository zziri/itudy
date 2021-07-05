// MEMO : 완전탐색은 기본기본

// Runtime: 2 ms, faster than 98.25% of Java online submissions for Combination Sum.
// Memory Usage: 39.3 MB, less than 47.39% of Java online submissions for Combination Sum.
class Solution {
    private LinkedList<Integer> bucket;
    private List<List<Integer>> result;

    private void combi(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new LinkedList(bucket));
            return;
        }
        
        for (int i=start; i<candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                bucket.addLast(candidates[i]);
                combi(candidates, target, sum+candidates[i], i);
                bucket.removeLast();
            } else {
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        bucket = new LinkedList<>();
        Arrays.sort(candidates);
        
        combi(candidates, target, 0, 0);
        
        return result;
    }
}
