import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree226 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		
		invertTree(root);
	}

	public static TreeNode invertTree(TreeNode root) {
	    if (root == null) {
	        return null;
	    }
	    TreeNode right = invertTree(root.right);
	    TreeNode left = invertTree(root.left);
	    root.left = right;
	    root.right = left;
	    return root;
	}
	
	public static TreeNode invertTreeBFS(TreeNode root) {
		if (root == null) return null;
		
		Queue<TreeNode> queue = new ArrayDeque<>();
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode currNode = queue.poll();
			TreeNode temp = currNode.left;
			currNode.left = currNode.right;
			currNode.right = temp;
			if (currNode.left != null) queue.offer(currNode.left);
			if (currNode.right != null) queue.offer(currNode.right);
		}
		
		return root;
	}
}
