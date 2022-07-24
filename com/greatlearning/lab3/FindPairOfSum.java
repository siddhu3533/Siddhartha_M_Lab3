package com.greatlearning.lab3;

import java.util.HashSet;
import java.util.Set;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int data) {
		super();
		this.data = data;
	}		
}

public class FindPairOfSum {
	static TreeNode root;
	
	//To call recursive insert new TreeNode method
	private void insertIntoBinarySearchTree(int data) {
		root = insertNewBinarySearchTreeNode(root,data);
	}
	
	//Recursing method to insert new TreeNode in Binary search tree.
	private TreeNode insertNewBinarySearchTreeNode(TreeNode root,int data) {
		if(root == null) {
			root = new TreeNode(data);
		}
		else if(data<root.data) {
			root.left = insertNewBinarySearchTreeNode(root.left,data);
		}
		else if(data>root.data) {
			root.right = insertNewBinarySearchTreeNode(root.right,data);
		}
		return root;
	}
	
	//Inorder traversal of Binary Search tree
	private void inorder(TreeNode root) {
		if(root == null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.data+", ");
			inorder(root.right);
		}
	}
	
	//To create a set and call recursive findPairUtil to find the pair.
	private void findPair(TreeNode root, int sum) {
		Set<Integer> set = new HashSet<Integer>();
		if(!findPairUtil(root,sum,set)) {
			System.out.println("\nTreeNodes are not found");
		}
	}
	
	//Recursive method to traverse tree and add data to set to find the pair.
	private boolean findPairUtil(TreeNode root, int sum, Set<Integer> set)
	{
		if(root==null) {
			return false;
		}
		
		if(findPairUtil(root.left,sum,set)) {
			return true;
		}
		
		if(set.contains(sum- root.data)) {
			System.out.println("\nPair is found ("+(sum-root.data) + ","+ root.data +")");
			return true;
		}
		else {
			set.add(root.data);
		}
		
		return findPairUtil(root.right,sum,set);
	}
	
	public static void main(String[] args) {
		FindPairOfSum tree = new FindPairOfSum();
		tree.insertIntoBinarySearchTree(40);
		tree.insertIntoBinarySearchTree(20);
		tree.insertIntoBinarySearchTree(10);
		tree.insertIntoBinarySearchTree(30);
		tree.insertIntoBinarySearchTree(60);
		tree.insertIntoBinarySearchTree(50);
		tree.insertIntoBinarySearchTree(70);
		System.out.println("Inorder traversal of tree");
		tree.inorder(root);
		int sum = 100;
		tree.findPair(root,sum);
	}

}
