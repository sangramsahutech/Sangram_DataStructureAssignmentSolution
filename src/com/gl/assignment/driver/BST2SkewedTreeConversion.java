package com.gl.assignment.driver;
/*
 * 
 * Logic -  1. Insert elements into the BST.
 * 			2. Recursively do inorder traversal and then push the data item into the new skewed tree by making its left child null
 * 			3. I am keeping the reference of root in a prev node so as to insert the next element into the right child of prev node.
 * 			4. Finally print the skewed tree by reading the right child of every node starting from head node recursively.
 */
public class BST2SkewedTreeConversion {
	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data=data;
			this.left=this.right=null;
		}
	}
	public static Node node;
	static Node head = null;
	static Node prev = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST2SkewedTreeConversion tree = new BST2SkewedTreeConversion();
		tree.node = new Node(50);
		tree.node.left=new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.left.right = new Node(40);
		inorderTrav(node);
		getSkewedTree(head);
	}
	private static void getSkewedTree(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		System.out.print(root.data+" ");
		getSkewedTree(root.right);
	}
	private static void inorderTrav(Node root) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		inorderTrav(root.left);
		if(head==null) {
			head = root;
			root.left = null;
			prev = root;
		} else {
			prev.right = root;
			root.left=null;
			prev = root;
		}
		inorderTrav(root.right);
	}
}
