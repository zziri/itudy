// MEMO : 드디어 풀었지만 답 보고 풀었으니까 다음에 다시 풀어보자
// need to re-solve

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        for (int i=0; i<nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int j = i + 1, k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j += 1;
                } else if (sum > 0) {
                    k -= 1;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    int backup = nums[j];
                    while (j < nums.length && backup == nums[j])
                        j += 1;
                    backup = nums[k];
                    while (k > 0 && backup == nums[k])
                        k -= 1;
                }
            }
        }
        return ret;
    }
}
