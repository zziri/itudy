// MEMO : 트리문제는 생각을 단순하게 하자, 너무 복잡하게 생각한다

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
    Memory Usage: 39 MB, less than 81.29% of Java online submissions for Populating Next Right Pointers in Each Node.
*/
class Solution {
    private void resolve(Node parent) {
        if (parent.left == null || parent.right == null)
            return;
        
        parent.left.next = parent.right;
        if (parent.next == null)
            return;
        
        parent.right.next = parent.next.left;
    }
    
    public Node connect(Node root) {
        if (root == null)
            return null;

        resolve(root);
        connect(root.left);
        connect(root.right);

        return root;
    }
}
