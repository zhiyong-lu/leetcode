import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145 {
	  public class TreeNode {
	    	int val;
	    	TreeNode left;
	    	TreeNode right;
	    	TreeNode() {}
	    	TreeNode(int val) { this.val = val; }
	    	TreeNode(int val, TreeNode left, TreeNode right) {
	    		this.val = val;
	    		this.left = left;
	    	 	this.right = right;
	    	}
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);

	}
	
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode currNode = stack.pop();
        	if (currNode != null) {
        		list.add(0, currNode.val);
        		stack.push(currNode.left);
        		stack.push(currNode.right);
        	}
        }
        
        return list;
    }
    
//    public class TreeNode {
//    	int val;
//    	TreeNode left;
//    	TreeNode right;
//    	TreeNode() {}
//    	TreeNode(int val) { this.val = val; }
//    	TreeNode(int val, TreeNode left, TreeNode right) {
//    		this.val = val;
//    		this.left = left;
//    	 	this.right = right;
//    	}
//    }

}
