import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthofBinaryTree104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	if (size > 0)
        		depth++;
        	for (int i = 0; i < size; i++) {
        		TreeNode curr = queue.poll();
        		if (curr.left != null) queue.offer(curr.left);
        		if (curr.right != null) queue.offer(curr.right);
        	}
        }
        
        return depth;
    }

}
