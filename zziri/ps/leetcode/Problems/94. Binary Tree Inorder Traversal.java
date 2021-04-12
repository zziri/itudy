// MEMO : 트리 순회는 거의 기계적으로 작성해야한다

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
    Memory Usage: 37.3 MB, less than 32.41% of Java online submissions for Binary Tree Inorder Traversal.
*/
class Solution {
    private void inorderTraversal(TreeNode cur, List<Integer> path) {
        if (cur == null)
            return;
        inorderTraversal(cur.left, path);
        path.add(cur.val);
        inorderTraversal(cur.right, path);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversal(root, ret);
        return ret;
    }
}
