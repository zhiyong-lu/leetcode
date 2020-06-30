//111. Minimum Depth of Binary Tree

//https://www.cnblogs.com/grandyang/p/4288151.html
//https://www.cnblogs.com/grandyang/p/4042168.html
public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(); 
        root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
  
        System.out.println("The minimum depth of "+ 
          "binary tree is : " + minDepth(root)); 

	}
	
    public static int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	if (root.left == null && root.right == null ) return 1;
    	if (root.left == null) return minHeight(root.right)+1;
    	if (root.right == null) return minHeight(root.left)+1;
    	
    	return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
    }

	private static int minHeight(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null ) return 1;
		
		return 1+Math.min(minHeight(root.left), minHeight(root.right));
	}
    
    

}
