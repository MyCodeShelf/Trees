package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
TreeNode root;

public BinarySearchTree()
{
	root=null;
}
public TreeNode insertNode(TreeNode root,int data)
{
	if(root==null)
	{
		root=new TreeNode(data);
	}
	else if(data<root.data)
		root.left=insertNode(root.left, data);
	else if(data>root.data)
		root.right=insertNode(root.right, data);
	
	return root;
}
//DFS traversals
public void inorderTraversal(TreeNode n)
{
	if(n==null)
		return;
	if(n!=null)
	{inorderTraversal(n.left);
		System.out.println(n.data);
		inorderTraversal(n.right);
	}
		
}
public void preorderTraversal(TreeNode n)
{
	if(n==null)
		return;
	if(n!=null)
	{
		System.out.println(n.data);
		inorderTraversal(n.left);
		inorderTraversal(n.right);
	}
	
}
public void postorderTraversal(TreeNode n)
{
	if(n==null)
		return;
	if(n!=null)
	{
		
		inorderTraversal(n.left);
		inorderTraversal(n.right);
		System.out.println(n.data);
	}
	
}
//BFS Traversal in a queue that is level order traversal
public void levelOrderTraversal(TreeNode n)
{
	if(n==null)
		return;
	Queue<TreeNode> qu=new LinkedList<TreeNode>();
	qu.add(n);
	while(!qu.isEmpty())
	{
		n=qu.poll();
		System.out.println(n.data);
		if(n.left!=null)
			qu.add(n.left);
		if(n.right!=null)
			qu.add(n.right);
	}
}
public TreeNode searchNode(TreeNode root ,int key)
{
	if(root==null)
		return root;
	else if(root.data==key)
		return root;
	else if(root.data>key)
	return	root.left=searchNode(root.left, key);
	else if(root.data<key)
		return	root.right=searchNode(root.right, key);
	return root;
}
/*
Given the root node of a binary search tree (BST) and a value.
 You need to find the node in the BST that the node's value equals the given value.
  Return the subtree rooted with that node. 
  If such node doesn't exist, you should return NULL.
  For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2     
     / \   
    1   3
    BELOW SOLUTION:
*/
public TreeNode searchNodeNPrintSubTree(TreeNode root ,int key)
{
	if(root==null)
		return root;
	else if(root.data==key)
		return root;
	root.left=searchNodeNPrintSubTree(root.left, key);
    root.right=searchNodeNPrintSubTree(root.right,key);
    return root=root.left!=null?root.left:root.right;
}
}
