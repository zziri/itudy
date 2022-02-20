// MEMO : 간단한 문제라도 감 잃지않게!

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
// Memory Usage: 36.6 MB, less than 40.15% of Java online submissions for Invert Binary Tree.

class Solution {
    private void swapTree(TreeNode node) {
        if (node == null)
            return;
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        swapTree(node.left);
        swapTree(node.right);
    }
    public TreeNode invertTree(TreeNode root) {
        swapTree(root);
        return root;
    }
}
