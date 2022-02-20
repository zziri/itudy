// MEMO : constructor를 잘 모를 때에는 그냥 무식하게 코드 짜는게 낫다

/*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Combinations.
    Memory Usage: 40.5 MB, less than 28.96% of Java online submissions for Combinations.
*/
class Solution {
    private List<Integer> toList(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for (int i : arr) {
            ret.add(i);
        }
        return ret;
    }

    private void combine(int n, int r, int depth, List<List<Integer>> list, int[] arr, int start) {
        if (depth == r) {
            List<Integer> newlist = toList(arr);
            list.add(newlist);
            return;
        }
        for (int i=start; i<=n-r+depth+1; i++) {
            arr[depth] = i;
            combine(n, r, depth+1, list, arr, i+1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        int[] temp = new int[k];
        combine(n, k, 0, ret, temp, 1);
        return ret;
    }
}
