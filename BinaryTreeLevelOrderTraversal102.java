import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> resList = new ArrayList<>();
    	if (root == null) return resList;
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	int size = 0;
    	while (!queue.isEmpty()) {
    		size = queue.size();
    		List<Integer> currList = new ArrayList<>();
    		for (int i = 0; i < size; i++) {
    			TreeNode curr = queue.poll();
    			currList.add(curr.value);
    			if (curr.left != null) queue.add(curr.left);
    			if (curr.right != null) queue.add(curr.right);
    		}
    		resList.add(currList);
    	}
        return resList;
    }

}
