import java.util.Stack;

public class ValidateBinarySearchTree98 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-2147483648);
		isValidBST(root);
	}
	
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long previous = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
        	while (root != null) {
        		stack.push(root);
        		root = root.left;
        	}
            root = stack.pop();
            if (root.value <= previous) {
                return false;
            } else {
                previous = root.value;
            }
            root = root.right;
        }
        return true;
    }
    
    public boolean isValidBSTZZZ(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
//        TreeNode p = root;
        int pre = Integer.MIN_VALUE;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.val <= pre) return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }

}
