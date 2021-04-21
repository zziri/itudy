class Solution {
    private List<Integer> list;
    
    private void inorder(TreeNode cur) {
        if (cur == null)
            return;
        
        if (cur.left != null || cur.right != null) {
            inorder(cur.left);
            list.add(cur.val);
            inorder(cur.right);
        } else {
            list.add(cur.val);
        }
    }

    private boolean isPalindrome() {
        int len = list.size();
        for (int l=0, r=len-1; l < r; ++l, --r) {
            if(list.get(l) != list.get(r)){
                return false;
            }
        }
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        System.out.println(list.toString());

        return isPalindrome();
    }
}
