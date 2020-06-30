//110. Balanced Binary Tree

//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class BalancedBinaryTree {

	public static void main(String[] args) {

	}
	
    public static boolean isBalanced(TreeNode root) {
    	if (root.left == null && root.right ==null) return true;
    	
    	return Math.abs(height(root.left) - height(root.right)) > 1;
        
    }

	private static int height(TreeNode root) {
		if (root==null) return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
		
	}

}
