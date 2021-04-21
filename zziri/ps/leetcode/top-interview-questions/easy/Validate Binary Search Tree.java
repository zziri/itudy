class Solution {
    private Integer val;
    private boolean result;

    private void travel(TreeNode cur) {
        if (cur == null)
            return;
        
        travel(cur.left);
        if (val == null) {
            val = cur.val;
        } else {
            if (val >= cur.val) {
                result = false;
            } else {
                val = cur.val;
            }
        }
        travel(cur.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        val = null; result = true;
        travel(root);
        
        return result;
    }
}
