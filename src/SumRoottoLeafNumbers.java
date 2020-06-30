import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//129. Sum Root to Leaf Numbers
public class SumRoottoLeafNumbers {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		
		int result = sumNumbersPreOrderIterative(root);
	}

	private static int sumNumbersRecursive(TreeNode root) {
		if (root==null) return 0;

		return helper(root, 0);

	}

	private static int helper(TreeNode root, int sum) {
		if (root == null) return 0;
		
		sum = sum*10 + root.value;
		
		if (root.left==null && root.right==null) {
			return sum;
		}
		
		return helper(root.left, sum) + helper(root.right, sum);
	}
	
	private static int sumNumbersPreOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		
		stack.add(root);

		int total = 0;
		while (!stack.isEmpty()) {
			TreeNode curNode = stack.pop();
			
			if (curNode.left==null && curNode.right==null) {
				total +=curNode.value;
			}
			
			if (curNode.right != null) {
				curNode.right.value += curNode.value*10;
				stack.push(curNode.right);
			}
			
			if (curNode.left != null) {
				curNode.left.value += curNode.value*10;
				stack.push(curNode.left);
			}
		}
		
		return total;
	}
	
	
	/*
    public static int sumNumbersRecursiveZZZ(TreeNode root) {
        if (root == null) return 0;
        
        List<List<Integer>> returnLists = new ArrayList<>();
        
    	List<Integer> stack = new ArrayList<>();
    	
    	helper(root, stack, returnLists);
    	
    	int total = 0;
    	for (List<Integer> list: returnLists) {
    		int root2leafVale = 0;
    		for (int i=0;i<list.size();i++) {
    			root2leafVale = root2leafVale*10 + list.get(i);
    		}
    		total += root2leafVale;
    	}
    	
    	return total;
    }

	private static void helper(TreeNode root, List<Integer> stack, List<List<Integer>> returnLists) {
		if (root==null) return;
		
		stack.add(root.value);
		
		if (root.left == null && root.right == null) {
			List<Integer> temp = new ArrayList<>(stack);
			returnLists.add(temp);
		}
		
		helper(root.left, stack, returnLists);
		helper(root.right, stack, returnLists);
		
		stack.remove(stack.size()-1);
	}
*/
}
