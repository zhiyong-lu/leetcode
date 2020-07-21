//110. Balanced Binary Tree

//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class BalancedBinaryTree110 {

	public static void main(String[] args) {

	}

//	https://www.youtube.com/watch?v=Be5CUodZliM
    public static boolean isBalanced(TreeNode root) {
    	if (root == null) return true;
    	
    	return height(root) == -1 ? false : true;
    }

	private static int height(TreeNode currNode) {
		if (currNode == null) return 0;
		
		int leftHeight = height(currNode.left);
		int rightHeight = height(currNode.right);
		
		if (leftHeight == -1 || rightHeight == -1) return -1;
		if (Math.abs(leftHeight - rightHeight) > 1) return -1;
				
		return 1 + Math.max(height(currNode.left), height(currNode.right)) ;
	}
	
}
