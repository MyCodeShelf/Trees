package trees;

public class MainTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
BinaryTreeImpl btree=new BinaryTreeImpl();
btree.root=new TreeNode(6);
btree.root.left=new TreeNode(7);
btree.root.right=new TreeNode(8);
btree.root.left.left=new TreeNode(77);
btree.traverseInorder(btree.root);
btree.traversePreorder(btree.root);
btree.traversePostorder(btree.root);
//System.out.println(btree.findLeafNode(btree.root));
System.out.println(btree.findSize(btree.root));
System.out.println(btree.lookup(btree.root, 7));
System.out.println(btree.lookupNode(btree.root, 7));
System.out.println(btree.findMinimum(btree.root));
int d=btree.findDepth(btree.root);
//btree.printLevelOrder(btree.root, d);
System.out.println(btree.LowestCommonAncestor(btree.root, 8, 77).data);
System.out.println(btree.isBST(btree.root, Integer.MIN_VALUE  , Integer.MAX_VALUE));
	}

}
