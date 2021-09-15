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
	
	public TreeNode createBT() { // create an empty binary tree(���� ���� Ʈ��)
		root = null;
		return root;
	}
	
	public boolean isEmpty(TreeNode bt) { // ���� Ʈ���� �������� �ƴ����� Ȯ���ϴ� ����
		if (bt == null) {
			return true;
		}
		else return false;
	}
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) { // �ΰ��� ���� ���� Ʈ���� �����Ͽ� �ϳ��� ���� Ʈ���� ����� ����
		TreeNode root = new TreeNode();
		root.data = data; // data : ��Ʈ 
		root.left = bt1; // ���� ���� Ʈ��
		root.right = bt2; // ������ ���� Ʈ��
		return root;
	}
	
	public TreeNode leftSubtree(TreeNode bt) { // ���� Ʈ���� ���� ���� Ʈ���� ���ϴ� ����
		if (isEmpty(bt)) return null;
		else return bt.left;
	}
	
	public TreeNode rightSubtree(TreeNode bt) { // ���� Ʈ���� ������ ���� Ʈ���� ���ϴ� ����
		if (isEmpty(bt)) return null;
		else return bt.right;
	}
	
	public Object data(TreeNode bt) { // ���� Ʈ������ ��Ʈ ����� ������(data)�� ���ϴ� ����
		if (isEmpty(bt)) return null;
		else return bt.data;
	}
	
	// 4���� ��ȸ���
	public void preorder(TreeNode root) { // DLR ������ ��ȸ
		if(root != null) {
			System.out.printf("%C", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) { // LDR ������ ��ȸ
		if(root != null) {
			inorder(root.left);
			System.out.printf("%C", root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) { // LRD ������ ��ȸ
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%C", root.data);
		}
	}
	
	public void levelorder(TreeNode root) { // �� �������� L���� R�� ��ȸ
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
