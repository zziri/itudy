// MEMO : List -> LinkedList casting 할 때에는 (LinkedList<T>)에서 제네릭 타입 생략 가능!

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    Memory Usage: 38.8 MB, less than 89.06% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/
class Solution {
    private void order(int depth, List<List<Integer>> trace, TreeNode cur) {
        if (cur == null)
            return;
        
        if (trace.size() <= depth)
            trace.add(new LinkedList<>());
        
        if (depth % 2 == 0)
            trace.get(depth).add(cur.val);
        else
            ((LinkedList)trace.get(depth)).addFirst(cur.val);
        
        order(depth+1, trace, cur.left);
        order(depth+1, trace, cur.right);
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        order(0, ret, root);
        return ret;
    }
}
