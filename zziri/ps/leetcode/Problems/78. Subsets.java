// MEMO : nCr 조합할 때 r이 0~n인 경우 비트마스킹도 좋은 방법이다

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
    Memory Usage: 39 MB, less than 87.58% of Java online submissions for Subsets.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int limit = 1 << nums.length;

        for (int bits=0; bits<limit; bits++) {
            List<Integer> subset = new ArrayList<>();
            for (int bit=1, index=0; bit<limit; bit <<= 1, index++) {
                if ((bits & bit) == 0)
                    continue;
                subset.add(nums[index]);
            }
            ret.add(subset);
        }

        return ret;
    }
}

/*
    Runtime: 1 ms, faster than 52.86% of Java online submissions for Subsets.
    Memory Usage: 39.4 MB, less than 30.57% of Java online submissions for Subsets.
*/
/*
class Solution {
    private List<Integer> temp;
    private List<List<Integer>> result;

    private void combi(int depth, int start, int[] nums, int r) {
        if (depth == r) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i <= nums.length + depth - r; i++) {
            temp.add(nums[i]);
            combi(depth+1, i+1, nums, r);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        temp = new ArrayList<>();
        result = new ArrayList<>();
        for (int len=0; len<=nums.length; len++) {
            combi(0, 0, nums, len);
        }
        return result;
    }
}
*/
