import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import BinaryTreePostorderTraversal145.TreeNode;

public class BinaryTreeInorderTraversal94 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		inorderTraversal(root);
	}
	
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        
        return list;
    }

	private static void inorderTraversalHelper(TreeNode node, List<Integer> list) {
		if (node==null) return;
		
		if (node.left != null) inorderTraversalHelper(node.left, list);
		list.add(node.value);
		if (node.right != null) inorderTraversalHelper(node.right, list);
	}

	public static List<Integer> inorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode currNode = root;
		while (currNode != null || !stack.isEmpty()) {
			while (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
			
			currNode  = stack.pop();
			list.add(currNode.value);
			currNode = currNode.right;
		}
		
		return list;
	}
}
