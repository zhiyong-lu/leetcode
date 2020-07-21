import java.util.Stack;

public class MinimumDistanceBetweenBSTNodes {

	static int previousValue = -1;
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		System.out.println(minDiffInBSTR(root));
//		System.out.println(minDiffInBSTI(root));
	}

    public static int minDiffInBSTR(TreeNode root) {
//    	int previousValue = -1;
//		int minDiff = Integer.MAX_VALUE;
        return helper(root);
    }
    
    public static int helper (TreeNode tn) {
    	if (tn == null) return 0;
    	
    	helper(tn.left);
    	
    	if (previousValue != -1)
    		minDiff = Math.min(Math.abs(tn.value - previousValue), minDiff); 
    	previousValue = tn.value;
    	
    	helper(tn.right);
    	
    	return minDiff;
    }
    
    public static int minDiffInBSTI(TreeNode root) {
    	int previousValue = -1;
		int minDiff = Integer.MAX_VALUE;
		
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			TreeNode temp = stack.pop();
			if (previousValue != -1) {
				minDiff = Math.min(Math.abs(temp.value-previousValue), minDiff);
			};
			previousValue = temp.value;
			
			root = temp.right;
		}
		
		return minDiff;
    }
    	
}
