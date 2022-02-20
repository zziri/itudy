// MEMO : Set, Map Class가 생각보다 느리다. swap 하는 방법으로도 순열 구현해봐야한다.

// 1 ms, 92.80 %
class Solution {
    private List<List<Integer>> ret;
    private boolean[] picked;
    private List<Integer> temp;

    private void recur(int depth, int[] nums) {
        if (depth == nums.length) {
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (picked[i])
                continue;

            picked[i] = true;
            temp.add(nums[i]);
            recur(depth+1, nums);
            temp.remove(temp.size()-1);
            picked[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        picked = new boolean[nums.length];
        temp = new ArrayList<>();
        recur(0, nums);

        return ret;
    }
}

// 3 ms, 17.90 %
/*
class Solution {
    private List<List<Integer>> ret;
    private Set<Integer> temp;

    private void recur(int depth, int[] nums) {
        if (depth == nums.length) {
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (temp.contains(nums[i]))
                continue;

            temp.add(nums[i]);
            recur(depth+1, nums);
            temp.remove(nums[i]);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        temp = new LinkedHashSet<>();
        recur(0, nums);

        return ret;
    }
}
*/