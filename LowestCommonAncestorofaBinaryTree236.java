//https://www.cnblogs.com/yrbbest/p/5003803.html
public class LowestCommonAncestorofaBinaryTree236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) 
            return null;
        if (root == p || root == q) 
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);      // Post order traveral
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null)          // p and q in two subtrees
            return root;
        else
            return left != null ? left : right; 
    }
	
	 public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null || root == p || root == q) return root;
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        if (left != null && right != null) return root;
	        else return left != null ? left : right;
	    }
	 
	  public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) return null;
	        if (root == p || root == q) return root;
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        if (left != null && right != null) return root;
	        else return (left != null) ? left : right;
	    }
	  
	  public TreeNode lowestCommonAncestorZZZ(TreeNode root, TreeNode p, TreeNode q) {
		  if (root == null || root.value == p.value || root.value == q.value) return root;
		  
		  TreeNode left = lowestCommonAncestorZZZ(root.left, p, q);
		  TreeNode right = lowestCommonAncestorZZZ(root.right, p, q);
		  
		  if (left != null && right != null) return root;

		  return (left != null) ? left:right;
	  }

}
