import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//112. Path Sum
public class PathSum {

	public static void main(String[] args) {
//		List<TreeNode> origList = new ArrayList<>();
//		origList.add(new TreeNode(4));
//		origList.add(new TreeNode(5));
//		origList.add(new TreeNode(6));
//		List<TreeNode> copyList1 = new ArrayList<>(origList);
//		List<TreeNode> copyList2 = new ArrayList<>();
//		copyList2.addAll(origList);
//		
//		origList.remove(1);
//		origList.add(new TreeNode(7));
	}
	
    public boolean hasPathSumR(TreeNode root, int sum) {
    	if (root == null) {
    		return sum == 0;
    	}
    	
    	if (root.left == null && root.right == null) {
    		return (sum == root.value);
    	}

    	return hasPathSumR(root.left, sum-root.value) || hasPathSumR(root.right, sum-root.value);
    }
    
    public boolean hasPathSumI(TreeNode root, int sum) {
    	if (root==null) return false;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode curNode = stack.pop();
    		
    		if (curNode.left==null && curNode.right==null && curNode.value == sum) return true;
    		
    		if (curNode.right!=null) {
    			curNode.right.value += curNode.value;
    			stack.push(curNode.right);
    		}
    		
    		if (curNode.left!=null) {
    			curNode.left.value += curNode.value;
    			stack.push(curNode.left);
    		}
    	}
    	
    	return false;
    }

}
