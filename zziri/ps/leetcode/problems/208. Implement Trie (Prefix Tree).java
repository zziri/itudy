// MEMO : Trie 도 제대로 구현 못하는 상태.. Array를 잡으면 초기에는 모두 null이다

// Runtime: 32 ms, faster than 62.00% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 47.9 MB, less than 93.73% of Java online submissions for Implement Trie (Prefix Tree).
class Node {
    public Node[] next = new Node[26];
    public boolean isLast = false;
}

class Trie {
    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node = node.next[index];
        }
        node.isLast = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return node.isLast;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return true;
    }
}
