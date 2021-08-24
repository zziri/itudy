// MEMO : 상당히 쓸데없이 복잡하게 풀었다

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
// Memory Usage: 38.6 MB, less than 94.64% of Java online submissions for Diameter of Binary Tree.
class Solution {
    private int result;
    
    private void travel(TreeNode node) {
        if (node == null)
            return;
        travel(node.left);
        travel(node.right);
        node.val = 1;
        if (node.left != null)
            node.val = Math.max(node.val, node.left.val + 1);
        if (node.right != null)
            node.val = Math.max(node.val, node.right.val + 1);
    }
    
    private void calMaxSum(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null && node.right != null) {
            result = Math.max(result, node.left.val + node.right.val);
        } else if (node.left != null) {
            result = Math.max(result, node.left.val);
        } else if (node.right != null) {
            result = Math.max(result, node.right.val);
        } else {
            return;
        }
        calMaxSum(node.left);
        calMaxSum(node.right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        travel(root);
        calMaxSum(root);
        return result;
    }
}
