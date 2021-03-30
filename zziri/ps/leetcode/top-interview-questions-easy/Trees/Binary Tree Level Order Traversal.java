class Solution {
    private List<List<Integer>> result;

    private void append(int index, int val) {
        if (result.size() <= index) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(val);
    }

    private void preorder(TreeNode node, int depth) {
        if (node == null)
            return;
        
        append(depth, node.val);
        preorder(node.left, depth+1);
        preorder(node.right, depth+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        preorder(root, 0);
        
        return result;
    }
}
