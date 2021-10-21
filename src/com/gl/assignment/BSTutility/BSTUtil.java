package com.gl.assignment.BSTutility;

import java.util.Arrays;

import com.gl.assignment.driver.BST2SkewedTreeConversion.Node;

public class BSTUtil {
	static int index;
	public boolean chkBST(Node root, Node l, Node r) {
		// TODO Auto-generated method stub
		if(root == null)
			return true;
		if(l != null && root.data <= l.data)
			return false;
		if(r != null && root.data >= r.data)
			return false;
		return chkBST(root.left, l, root) && chkBST(root.right, root, r);
	}

	public void convBST(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		int n = countNodes(node);
		int[] arr = new int[n];
		bTreeToArr(node, arr);
		Arrays.sort(arr);
		index=0;
		arrToBST(arr, node);
	}

	private void arrToBST(int[] arr, Node node) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		arrToBST(arr, node.left);
		node.data = arr[index];
		index++;
		arrToBST(arr, node.right);
	}

	private void bTreeToArr(Node node, int[] arr) {
		// TODO Auto-generated method stub
		if(node == null)
			return;
		bTreeToArr(node.left, arr);
		arr[index] = node.data;
		index++;
		bTreeToArr(node.right, arr);
	}
	
	private int countNodes(Node node) {
		// TODO Auto-generated method stub
		if(node == null)
			return 0;
		return countNodes(node.left) + countNodes(node.right)+1;
	}
}