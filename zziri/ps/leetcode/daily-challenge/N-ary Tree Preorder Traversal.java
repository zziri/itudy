// MEMO : 트리 순회는 간단하게 슥슥 풀어버려야지

class Solution {
    private void preorder(Node node, List<Integer> trace) {
        trace.add(node.val);
        for (Node child : node.children) {
            preorder(child, trace);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if (root != null)
            preorder(root, ret);
        return ret;
    }
}