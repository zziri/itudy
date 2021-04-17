// MEMO : order trace로 트리 만드는 문제는 이해가 잘 안되니까 자주 풀어야할듯..!

/*
    Runtime: 1 ms, faster than 98.36% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    Memory Usage: 38.8 MB, less than 80.70% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
*/
class Solution {
    private int preIdx;
    private Map<Integer, Integer> map;

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        
        int val = preorder[preIdx++];
        TreeNode node = new TreeNode(val);
        
        node.left = buildTree(preorder, left, map.get(val)-1);
        node.right = buildTree(preorder, map.get(val)+1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIdx = 0;
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1);
    }
}
