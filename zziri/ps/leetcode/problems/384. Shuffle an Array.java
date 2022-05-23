// MEMO : 너-무 느리다...

// Runtime: 121 ms, faster than 26.77% of Java online submissions for Shuffle an Array.
// Memory Usage: 67 MB, less than 56.81% of Java online submissions for Shuffle an Array.
class Solution {
    private int[] origin;
    private int[] temp;

    public Solution(int[] nums) {
        this.origin = Arrays.copyOf(nums, nums.length);
        this.temp = Arrays.copyOf(nums, nums.length);
    }
    
    public int[] reset() {
        this.temp = Arrays.copyOf(this.origin, this.origin.length);
        return this.temp;
    }
    
    public int[] shuffle() {
        List<Integer> list = toList(temp);
        Collections.shuffle(list);
        for (int i=0; i<temp.length; i++) {
            temp[i] = list.get(i);
        }
        return temp;
    }
    
    private List<Integer> toList(int[] arr) {
        List<Integer> ret = new ArrayList<>();
        for (int n : arr) {
            ret.add(n);
        }
        return ret;
    }
}
