import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//113. Path Sum II
public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> pathSumR(TreeNode root, int sum) {
    	if (root == null) return Collections.EMPTY_LIST;
    	
    	List<List<Integer>> returnLists = new ArrayList<>();
    	List<Integer> stack = new ArrayList<>();
//    	stack.add(root.value);
    	
    	helper(root, sum, stack, returnLists);
    	
    	return returnLists;
    }

	private static void helper(TreeNode root, int sum, List<Integer> stack, List<List<Integer>> returnLists) {
		if (root == null) return;
		
		stack.add(root.value);
		
		if (root.left==null && root.right == null && sum == 0) {
			List<Integer> tempList = new ArrayList<>();
			tempList.addAll(stack);
			returnLists.add(tempList);
		}
		
		helper(root.left, sum-root.value, stack, returnLists);
		helper(root.right, sum-root.value, stack, returnLists);
		
		stack.remove(stack.size()-1);
	}

}
