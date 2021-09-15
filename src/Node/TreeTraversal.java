package Node;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
	Object data;
	TreeNode left;
	TreeNode right;
}

class LinkedTree {
	private TreeNode root;
	
	public TreeNode createBT() { // create an empty binary tree(공백 이진 트리)
		root = null;
		return root;
	}
	
	public boolean isEmpty(TreeNode bt) { // 이진 트리가 공백인지 아닌지를 확인하는 연산
		if (bt == null) {
			return true;
		}
		else return false;
	}
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) { // 두개의 이진 서브 트리를 연결하여 하나의 이진 트리를 만드는 연산
		TreeNode root = new TreeNode();
		root.data = data; // data : 루트 
		root.left = bt1; // 왼쪽 서브 트리
		root.right = bt2; // 오른쪽 서브 트리
		return root;
	}
	
	public TreeNode leftSubtree(TreeNode bt) { // 이진 트리의 왼쪽 서브 트리를 구하는 연산
		if (isEmpty(bt)) return null;
		else return bt.left;
	}
	
	public TreeNode rightSubtree(TreeNode bt) { // 이진 트리의 오른쪽 서브 트리를 구하는 연산
		if (isEmpty(bt)) return null;
		else return bt.right;
	}
	
	public Object data(TreeNode bt) { // 이진 트리에서 루트 노드의 데이터(data)를 구하는 연산
		if (isEmpty(bt)) return null;
		else return bt.data;
	}
	
	// 4가지 순회방법
	public void preorder(TreeNode root) { // DLR 순서로 순회
		if(root != null) {
			System.out.printf("%C", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) { // LDR 순서로 순회
		if(root != null) {
			inorder(root.left);
			System.out.printf("%C", root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) { // LRD 순서로 순회
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%C", root.data);
		}
	}
	
	public void levelorder(TreeNode root) { // 각 레벨마다 L에서 R로 순회
		Deque<TreeNode> que = new ArrayDeque<TreeNode>();
		que.add(root);
		while (que.peek() != null) {
			TreeNode element = que.poll();
			System.out.printf("%C", element.data);
			if(element.left != null) {
				que.add(element.left);
			}
			if(element.right != null) {
				que.add(element.right);
			}
		}
//		levelorderRecursion(que);
	}
	
	private void levelorderRecursion(Deque<TreeNode> que) {
		if (que.peek()==null) {
			return;
		} else {
			TreeNode element = que.poll();
			System.out.printf("%C", element.data);
			if(element.left != null) {
				que.add(element.left);
			}
			if(element.right != null) {
				que.add(element.right);
			}
			levelorderRecursion(que);
		}
	}
}

class TreeTraversal {
	public static void main(String[] args) {
		LinkedTree T = new LinkedTree();
		
		TreeNode n7 = T.makeBT(null, 'D', null);
		TreeNode n6 = T.makeBT(null, 'C', null);
		TreeNode n5 = T.makeBT(null, 'B', null);
		TreeNode n4 = T.makeBT(null, 'A', null);
		TreeNode n3 = T.makeBT(n6, '/', n7);
		TreeNode n2 = T.makeBT(n4, '*', n5);
		TreeNode n1 = T.makeBT(n2, '-', n3);

		System.out.printf("\n Preorder : ");
		T.preorder(n1);

		System.out.printf("\n Inorder : ");
		T.inorder(n1);
		
		System.out.printf("\n Postorder : ");
		T.postorder(n1);
		
		System.out.printf("\n Levelorder : ");
		T.levelorder(n1);
	}
}
