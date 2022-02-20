// MEMO : List<Object> class에 pop 함수는 없다고

/*
    Runtime: 6 ms, faster than 26.45% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
    Memory Usage: 40.6 MB, less than 86.14% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
*/
class Solution {
    private void travel(TreeNode current, TreeNode target, List<TreeNode> path, List<TreeNode> temp) {
        if (current == null || !path.isEmpty())
            return;
        temp.add(current);
        if (current == target) {
            for (TreeNode node : temp) {
                path.add(node);
            }
            return;
        }
        
        travel(current.left, target, path, temp);
        travel(current.right, target, path, temp);
        temp.remove(temp.size()-1);
    }
    
    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> ret = new ArrayList<>();
        travel(root, target, ret, new ArrayList<>());
        return ret;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        int len = Math.min(path1.size(), path2.size());
        
        if (path1.size() > len)
            path1 = path1.subList(0, len);
        if (path2.size() > len)
            path2 = path2.subList(0, len);
        
        for (int i=len-1; i>=0; i--) {
            if (path1.get(i) == path2.get(i)) {
                return path1.get(i);
            }
        }
        
        return root;
    }
}
