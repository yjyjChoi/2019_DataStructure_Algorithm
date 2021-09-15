package binarySearchTree;

public class BST {
	class Node {
		char key;
		Node parent; // double linked list
		Node left;
		Node right;
	
		public Node(char k) {
			key = k;
			parent = null;
			left = null;
			right = null;
		}
		
		public String toString() {
			String returnval = "";
			return returnval+key;
		}
	}
	
	Node root;
	
	public BST() {
		root = null;
	}
	
	public Node insert(char x) {
		Node p = root;
		Node q = null;
		while (p != null) {
			if (x==p.key) 
				return root;
			q = p;
			if (x < p.key) 
				p = p.left;
			else 
				p = p.right;
		}
		Node newNode = new Node(x);
		if (root == null) 
			root = newNode;
		else {
			if (x < q.key)
				q.left = newNode;
			else
				q.right = newNode;
			newNode.parent = q;
		}
		return root;
	}
	
	public Node search(Node startNode, char x) {
		Node p = startNode;
		if ((p==null)||(x==p.key))
			return p;
		else if (x < p.key)
			return search(p.left, x);
		else
			return search(p.right, x);
	}
	
	public Node delete(Node startNode, char x) {
		Node v = search(startNode, x);
		if (v==null)
			return root;
		// case1 : no child
		if (v.left==null && v.right==null) {
			if (x < v.parent.key)
				v.parent.left = null;
			else 
				v.parent.right = null;
			return root;
		}
		// case2 : 1 child
		if (v.left==null || v.right==null) {
			if (v.right!=null) {
				if (v==v.parent.left) {
					v.parent.left = v.right;
					v.right.parent = v.parent;
				} else { // v==v.parent.right
					v.parent.right = v.right;
					v.right.parent = v.parent;
				}
			} else { // v.left!=null
				if (v==v.parent.left) {
					v.parent.left = v.left;
					v.left.parent = v.parent;
					
				} else { // v==v.parent.right
					v.parent.right = v.left;
					v.left.parent = v.parent;
				}
			}
			return root;
		}
		// case 3-1 : 2 children, let's pick successor
		else {
			Node q = successor(v);
			v.key = q.key;
			delete(v.right, q.key);
			return root;
		}
		// case 3-1 : children, let's pick predecessor
/*		else {
			Node q = predecessor(v);
			v.key = q.key;
			delete(v.right, q.key);
			return root;
		}*/
	}
	
	
	private Node successor(Node v) {
		if (v==null)
			return null;
		Node p = v.right;
		while (p.left!=null)
			p= p.left;
		return p;
	}
	
	private Node predecessor(Node v) {
		if (v==null)
			return null;
		Node p = v.left;
		while (p.right!=null)
			p= p.right;
		return p;
	}
	
	public String toString() {
		// inorder traverse
		return inorder(root);
	}
	
	public String toString(Node v) {
		// for printing subtree
		return inorder(v);
	}
	
	private String inorder(Node v) {
		if (v==null)
			return "";
		else 
			return inorder(v.left) + " " + v.key + " " + inorder(v.right);
	}

	public static void main(String[] args) {
		BST mybst = new BST();
		
		mybst.insert('F');
		mybst.insert('J');
		mybst.insert('S');
		mybst.insert('A');
		mybst.insert('C');
		mybst.insert('Q');
		mybst.insert('E');

		System.out.println(mybst.toString());
		System.out.println(mybst.toString(mybst.delete(mybst.root, 'Q')));
	}
}
