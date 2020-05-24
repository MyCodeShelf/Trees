package trees;

public class BinaryTreeImpl {
TreeNode root;
int count=0;
int lDepth=0;
int rDepth=0;
public BinaryTreeImpl(int value) {
	// TODO Auto-generated constructor stub
	root=new TreeNode(value);
}
public BinaryTreeImpl() {
	root=null;
}
public void traverseInorder(TreeNode n)
{
	if (n==null)
		return;
	else
	{
		traverseInorder(n.left);
		System.out.println(n.data);
		traverseInorder(n.right);
	}
	
}
public void traversePreorder(TreeNode n)
{
	if (n==null)
		return;
	else
	{
		
		System.out.println(n.data);
		traversePreorder(n.left);
		traversePreorder(n.right);
	}
	
}

public void traversePostorder(TreeNode n)
{
	if (n==null)
		return; 
	else
	{
		
		
		traversePreorder(n.left);
		traversePreorder(n.right);
		System.out.println(n.data);
	}
	
}
void printLevelOrder(TreeNode r, int depthorHeight) 
{ 
     
    int i; 
    for (i=1; i<=depthorHeight; i++) 
        traverseLevelOrder(r, i); 
} 
public void traverseLevelOrder(TreeNode n,int level)
{
	if(n==null)
	{
	//	System.out.println("Empty tree");
		return;
	}
	else if(level==1)
		System.out.println(n.data);
	else if(level>1) 
	{
		traverseLevelOrder(n.left, level-1);
		traverseLevelOrder(n.right, level-1);
	}
	
}
//find no of nodes in a binary tree
public int findSize(TreeNode n)
{
	//if(n==null )
	if (n == null) 
        return 0; 
	
	
 count=count+findLeafNode(n.left);
 count=count+findLeafNode(n.right);

	
	return count+1;
	
	
}
public int findLeafNode(TreeNode n)
{
	if (n == null) 
        return 0; 
	if(n.left==null && n.right==null)
		count=count+1;
	else 
	{
	findLeafNode(n.left);
	findLeafNode(n.right);
}
	
	return count;
	}
public void findLeafNodeDetail(TreeNode n)
{
	if (n == null) 
        return ;
	if(n.left==null && n.right==null)
	{
	System.out.println(n.data);
		
	}
	else 
	{
	findLeafNodeDetail(n.left);
	findLeafNodeDetail(n.right);
}

	}
public int findDepth(TreeNode n)
{
	
	if(n==null)
		return 0;
	else 
	{
	    lDepth=lDepth+findDepth(n.left);
	   rDepth=rDepth+findDepth(n.right);
	}
	if(lDepth>rDepth)
		return lDepth+1;
	else
		return rDepth+1;
}
public boolean lookup(TreeNode n,int d)
{
	if(n==null)
		return false;
	if(n.data==d)
		return true;
	boolean lresult=lookup(n.left, d);
	if(lresult)return true;
	boolean rresult=lookup(n.right, d);
	
	
	return rresult;
}
public TreeNode lookupNode(TreeNode n,int d)
{
	if(n==null)
		return n;
	if(n.data==d)
		return n;
	TreeNode lresult=lookupNode(n.left, d);
	if(lresult.data==d)return lresult;
	TreeNode rresult=lookupNode(n.right, d);
	
	
	return rresult;
}
public int findMinimum(TreeNode n)
{
	if(n==null)
	return 0;
	
	else
	{
		int min=n.data;
		if(n.left!=null)
		{
		int minleft=findMinimum(n.left);
		if(min>minleft) min=minleft;
		}
		if(n.right!=null)
		{
		int minright=findMinimum(n.right);
		if(min>minright) min=minright;
		}
		
		return min;
	}
}
	public TreeNode LowestCommonAncestor(TreeNode r,int n1 ,int n2)
	{
		if(r==null)
			return  null;
		else if(r.data==n1 || r.data==n2)
			return r;
		TreeNode left=LowestCommonAncestor(r.left,n1,n2);
		TreeNode right=LowestCommonAncestor(r.right,n1,n2);
		if(left!=null && right!=null)
			return r;
	
	return left!=null?left:right;
	}
public boolean isBST(TreeNode n,int min ,int max)
{
	if(n==null)
		return true;
	if(n.data>=max || n.data <min)
		return false;
	
	return isBST(n.left, min, n.data) && isBST(n.right, n.data, max);
}

}
