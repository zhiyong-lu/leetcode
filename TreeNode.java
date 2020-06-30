
public class TreeNode {
	TreeNode left;
	TreeNode right;
	Integer value;
	
	 TreeNode() {}
	 TreeNode(int val) { this.value = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
	 this.value = val;
	 this.left = left;
	 this.right = right;
	 }
}
