package tree;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insertNode(5);
		bst.insertNode(3);
		bst.insertNode(4);
		bst.insertNode(8);
		bst.insertNode(1);
		bst.insertNode(7);
		bst.insertNode(9);
		bst.insertNode(2);
		
		bst.deleteNode(5);
		bst.displayTree(bst.getRoot());

	}

}
