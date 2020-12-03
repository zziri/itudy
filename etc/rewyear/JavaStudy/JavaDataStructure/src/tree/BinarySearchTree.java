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
		
		if(root == null) // 비어있는 트리일 경우
		{
			root = newNode; 
		}
		
		while(tmp != null)	// 트리의 빈공간까지 찾아가는 연산
		{
			if(tmp.data == newNode.getData()) // 중복되는 경우 
			{
				System.out.println("중복되는 key값 입니다.");
			}				
			else if(newNode.getData() < tmp.data) // 삽입하려는 key 값이 현재 노드보다 작은경우
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
			if(key < target.data) // 삭제하려는 key 값이 현재 노드보다 작은경우
			{
				parent = target;
				target = parent.left; // 타겟위치 왼쪽으로 선정
				isLeft = true;
			}
			else
			{
				parent = target;
				target = parent.right; // 타겟위치를 오른쪽으로 선정
				isLeft = false;
			}
		}
		
		if(target == null) {
			System.out.println("찾는 key 값이 없습니다.");
			return false;
		}
		
		// case1. 단말노드인 경우
		if((target.left == null) && (target.right == null)) {
			if(target == root) {// 트리에 루트 하나만 있을경우
				target = null;
				return true;
			}
			
			// 부모노드와 삭제하려는 노드를 끊는 작업
			if(isLeft)
				parent.left = null;
			else
				parent.right = null;
		}
		// case2. 자식 노드가 1개인 경우
		else if(target.left == null)
		{ 
			// 트리에 루트 하나만 있을경우
			if(target == root) {
				target = target.right;
				return true;
			}
			// 삭제하려는 노드의 자식노드를 부모노드에 연결시켜줌
			if(isLeft)
				parent.left = target.right;
			else 
				parent.right = target.right;
		}
		else if(target.right == null)
		{
			// 트리에 루트 하나만 있을경우
			if(target == root) {
				target = target.left;
				return true;
			}
			// 삭제하려는 노드의 자식노드를 부모노드에 연결시켜줌
			if(isLeft)
				parent.left = target.left;
			else 
				parent.right = target.left;
		}
		//case3. 두 개의 서브트리를 가지는 경우
		else
		{
			TreeNode subParent = target;
			TreeNode subTarget = target.left; // 왼쪽서브트리에서 오른쪽링크로 단말노드가 나올때까지 검색 진행
			
			while(subTarget.right != null)
			{
				subParent = subTarget;
				subTarget = subTarget.right;				
			}

			// 후속 target의 자식노드를 후속 부모노드의 자식노드으로 변경(후속 target가 빠지니까)
			if(subTarget.left != null)
				subParent.right = subTarget.left;
			else
				subParent.right = subTarget.right;
	
			// 찾은 새로운 target을 target으로 변경
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
