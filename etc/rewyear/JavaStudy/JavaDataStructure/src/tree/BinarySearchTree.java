package tree;

public class BinarySearchTree {
	class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}
	
	private TreeNode root;

	public BinarySearchTree()
	{
		this.root = null;
	}
	
	public TreeNode searchNode(int key)
	{
		TreeNode node = root;
		while(node != null)	
		{
			if(key == node.data)
				return node;
			else if(key < node.data)
				node = node.left;
			else 
				node = node.right;
		}
		return null;
	}
	
	public void insertNode(int key)
	{
		TreeNode tmp = root;
		TreeNode parent = null;
		TreeNode newNode = new TreeNode(key);
		
		if(root == null) // ����ִ� Ʈ���� ���
		{
			root = newNode; 
		}
		
		while(tmp != null)	// Ʈ���� ��������� ã�ư��� ����
		{
			if(tmp.data == newNode.getData()) // �ߺ��Ǵ� ��� 
			{
				System.out.println("�ߺ��Ǵ� key�� �Դϴ�.");
			}				
			else if(newNode.getData() < tmp.data) // �����Ϸ��� key ���� ���� ��庸�� �������
			{
				parent = tmp;
				tmp = tmp.left; 
			}
			else
			{
				parent = tmp;
				tmp = tmp.right; 
			}
		}
		
		if(newNode.getData() < parent.getData())
			parent.left = newNode;
		else
			parent.right = newNode;
	}
	
	public boolean deleteNode(int key)
	{
		TreeNode target = root;
		TreeNode parent = null;
		boolean isLeft = false;
		
		while(target != null && target.data != key)	
		{
			if(key < target.data) // �����Ϸ��� key ���� ���� ��庸�� �������
			{
				parent = target;
				target = parent.left; // Ÿ����ġ �������� ����
				isLeft = true;
			}
			else
			{
				parent = target;
				target = parent.right; // Ÿ����ġ�� ���������� ����
				isLeft = false;
			}
		}
		
		if(target == null) {
			System.out.println("ã�� key ���� �����ϴ�.");
			return false;
		}
		
		// case1. �ܸ������ ���
		if((target.left == null) && (target.right == null)) {
			if(target == root) {// Ʈ���� ��Ʈ �ϳ��� �������
				target = null;
				return true;
			}
			
			// �θ���� �����Ϸ��� ��带 ���� �۾�
			if(isLeft)
				parent.left = null;
			else
				parent.right = null;
		}
		// case2. �ڽ� ��尡 1���� ���
		else if(target.left == null)
		{ 
			// Ʈ���� ��Ʈ �ϳ��� �������
			if(target == root) {
				target = target.right;
				return true;
			}
			// �����Ϸ��� ����� �ڽĳ�带 �θ��忡 ���������
			if(isLeft)
				parent.left = target.right;
			else 
				parent.right = target.right;
		}
		else if(target.right == null)
		{
			// Ʈ���� ��Ʈ �ϳ��� �������
			if(target == root) {
				target = target.left;
				return true;
			}
			// �����Ϸ��� ����� �ڽĳ�带 �θ��忡 ���������
			if(isLeft)
				parent.left = target.left;
			else 
				parent.right = target.left;
		}
		//case3. �� ���� ����Ʈ���� ������ ���
		else
		{
			TreeNode subParent = target;
			TreeNode subTarget = target.left; // ���ʼ���Ʈ������ �����ʸ�ũ�� �ܸ���尡 ���ö����� �˻� ����
			
			while(subTarget.right != null)
			{
				subParent = subTarget;
				subTarget = subTarget.right;				
			}

			// �ļ� target�� �ڽĳ�带 �ļ� �θ����� �ڽĳ������ ����(�ļ� target�� �����ϱ�)
			if(subTarget.left != null)
				subParent.right = subTarget.left;
			else
				subParent.right = subTarget.right;
	
			// ã�� ���ο� target�� target���� ����
			target.data = subTarget.getData();			
		}
		
		return false;	
	}
	
	public void displayTree(TreeNode t)
	{
		if(t != null) {
			displayTree(t.left);
			System.out.println(t.getData());
			displayTree(t.right);
		}
	}
}
