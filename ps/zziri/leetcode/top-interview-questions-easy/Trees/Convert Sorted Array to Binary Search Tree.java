class Solution {
    private TreeNode result;
    private int[] nums;

    private void makeTree(int l, int r, TreeNode cur) {
        int mid = (l+r)/2;
        cur.val = nums[mid];

        if (mid > l){
            cur.left = new TreeNode();
            makeTree(l, mid, cur.left);
        }
        if (r > mid+1) {
            cur.right = new TreeNode();
            makeTree(mid+1, r, cur.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        this.result = new TreeNode();
        makeTree(0, nums.length, result);
        
        return result;
    }
}
