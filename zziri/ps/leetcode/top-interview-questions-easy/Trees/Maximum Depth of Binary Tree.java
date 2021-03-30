class Solution {
    private int travel(int depth, TreeNode cur) {
        if (cur == null)
            return depth;
        
        int ret = 0;
        ret = Math.max(ret, travel(depth+1, cur.left));
        ret = Math.max(ret, travel(depth+1, cur.right));

        return ret;
    }
    
    public int maxDepth(TreeNode root) {
        return travel(0, root);
    }
}
