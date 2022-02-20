// MEMO : 여분의 메모리를 쓰지 않고 풀어보자

// Runtime: 2 ms, faster than 6.78% of Java online submissions for Flatten Binary Tree to Linked List.
// Memory Usage: 39.6 MB, less than 15.79% of Java online submissions for Flatten Binary Tree to Linked List.

class Solution {
    private TreeNode clearNode(TreeNode node) {
        node.left = null; node.right = null;
        return node;
    }
    
    private TreeNode linking(List<TreeNode> trace) {
        if (trace.isEmpty())
            return null;
        TreeNode ret = trace.get(0);
        for (int i=0; i<trace.size()-1; i++) {
            TreeNode cur = trace.get(i);
            TreeNode next = trace.get(i+1);
            if (ret == null) {
                ret = cur;
            }
            cur = clearNode(cur);
            cur.right = clearNode(next);
        }
        return ret;
    }
    
    private void preOrder(TreeNode cur, List<TreeNode> trace) {
        if (cur == null)
            return;
        trace.add(cur);
        preOrder(cur.left, trace);
        preOrder(cur.right, trace);
    }
    
    public void flatten(TreeNode root) {
        List<TreeNode> trace = new ArrayList<>();
        preOrder(root, trace);
        root = linking(trace);
    }
}
