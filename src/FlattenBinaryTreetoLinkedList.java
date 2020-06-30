import java.util.LinkedList;
import java.util.Queue;

//114. Flatten Binary Tree to Linked List

public class FlattenBinaryTreetoLinkedList {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		flattenRecursive(root);
	}
	
    public static TreeNode flattenMe(TreeNode root) {
    	Queue<Integer> queue = new LinkedList<>();
    	preorder(root, queue);
    	
        return flat(queue);
    }

	private static void preorder(TreeNode root, Queue<Integer> queue) {
		if (root == null) return;
		
		queue.offer(root.value);
		preorder(root.left, queue);
		preorder(root.right, queue);		
	}
	
//	https://www.cnblogs.com/grandyang/p/4293853.html

	private static TreeNode flat(Queue<Integer> queue) {
		if (queue.isEmpty()) return null;
		
		Integer curValue = queue.poll();
		TreeNode curNode = new TreeNode(curValue);
//		curNode.left = flat(queue);
		curNode.right = flat(queue);
		
		return curNode;
	}
	
    public static void flattenRecursive(TreeNode root) {
    	if (root==null) return;

    	if (root.left!=null) flattenRecursive(root.left);
    	if (root.right!=null) flattenRecursive(root.right);
    	
    	TreeNode temp = root.right;
    	root.right = root.left;
    	root.left = null;
    	while (root.right!=null) root=root.right;
    	root.right = temp;
    }
    
    public void flattenIterative(TreeNode root) {
    	while (root != null) {
    		if (root.left != null) {
    			TreeNode temp = root.left;
    			while (temp.right != null) {
    				temp = temp.right;
    			}
    			temp.right = root.right;
    			root.right = root.left;
    			root.left = null;
    		}
    		root = root.right;
    	}
    	
    }
}
