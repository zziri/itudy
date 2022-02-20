// MEMO : 추가 메모리는 안썼지만 좀 지저분하다

// Runtime: 1 ms, faster than 30.41% of Java online submissions for Merge Two Binary Trees.
// Memory Usage: 39.2 MB, less than 54.42% of Java online submissions for Merge Two Binary Trees.
class Solution {
    private void travel(TreeNode src, TreeNode dst) {
        if (src == null)
            return;
        dst.val += src.val;
        if (src.left != null) {
            if (dst.left == null)
                dst.left = new TreeNode(0);
            travel(src.left, dst.left);
        }
        if (src.right != null) {
            if (dst.right == null)
                dst.right = new TreeNode(0);
            travel(src.right, dst.right);
        }
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode ret = null;
        if (root1 != null || root2 != null)
            ret = new TreeNode();
        if (root1 != null)
            travel(root1, ret);
        if (root2 != null)
            travel(root2, ret);
        return ret;
    }
}
