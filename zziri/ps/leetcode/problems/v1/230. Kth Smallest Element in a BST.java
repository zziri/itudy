// MEMO : 꾸준히 하자

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
    Memory Usage: 38.5 MB, less than 91.37% of Java online submissions for Kth Smallest Element in a BST.
*/
class Solution {
    private int n;

    private int recur(TreeNode node, int k) {
        if (node == null)
            return 0;
        int ret = 0;
        ret |= recur(node.left, k);
        ++n;
        if (n == k)
            ret = node.val;
        ret |= recur(node.right, k);
        return ret;
    }

    public int kthSmallest(TreeNode root, int k) {
        n = 0;
        return recur(root, k);
    }
}
