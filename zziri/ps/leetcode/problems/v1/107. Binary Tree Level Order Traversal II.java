// MEMO : Map 너무 좋다

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
// Memory Usage: 39.1 MB, less than 61.75% of Java online submissions for Binary Tree Level Order Traversal II.
class Solution {
    private int travel(Map<Integer, List<Integer>> bucket, TreeNode node, int depth) {
        if (node == null)
            return depth-1;
        
        int ret = depth;
        
        if (!bucket.containsKey(depth))
            bucket.put(depth, new ArrayList<>());
        
        bucket.get(depth).add(node.val);
        
        ret = Math.max(travel(bucket, node.left, depth+1), ret);
        ret = Math.max(travel(bucket, node.right, depth+1), ret);
        
        return ret;
    }
    
    private List<List<Integer>> getList(int maxLevel, Map<Integer, List<Integer>> bucket) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int level = maxLevel; level >= 0; level--) {
            ret.add(bucket.get(level));
        }
        return ret;
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        int maxLevel = travel(bucket, root, 0);
        return getList(maxLevel, bucket);
    }
}
