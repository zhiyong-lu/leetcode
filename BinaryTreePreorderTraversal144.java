import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> preorderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();	
		List<Integer> list = new ArrayList<>();
		
		if (root != null) 
			stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			list.add(currNode.value);
			
			if (currNode.right != null) stack.push(currNode.right);
			if (currNode.left != null) stack.push(currNode.left);				
		}
		
		return list;
	}
	
}
