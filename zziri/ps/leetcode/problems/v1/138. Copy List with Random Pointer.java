// MEMO : mapping만 잘해도 쉽게 풀수있음

// Runtime: 1 ms, faster than 21.85% of Java online submissions for Copy List with Random Pointer.
// Memory Usage: 38.9 MB, less than 47.23% of Java online submissions for Copy List with Random Pointer.

class Solution {
    private Node getNode(Node head, int index) {
        Node ret = head;
        while (index-- > 0) {
            ret = ret.next;
        }
        return ret;
    }
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Node ret = null, pointer = null;
        Map<Node, Integer> originalListMap = new HashMap<>();
        Map<Integer, Node> indexMap = new HashMap<>();
        int index = 0;
        
        for (Node current = head; current != null; current = current.next) {
            if (current == head) {
                pointer = new Node(current.val);
                ret = pointer;
            } else {
                pointer.next = new Node(current.val);
                pointer = pointer.next;
            }
            originalListMap.put(current, index);
            indexMap.put(index++, pointer);
        }
        
        Node origin = head;
        Node node = ret;
        
        while (origin != null && node != null) {
            Integer to = originalListMap.get(origin.random);
            node.random = indexMap.get(to);
            
            origin = origin.next;
            node = node.next;
        }
        
        return ret;        
    }
}
