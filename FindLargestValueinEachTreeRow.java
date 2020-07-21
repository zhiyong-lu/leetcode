import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        if (root == null) return list;
        
        queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	int max = Integer.MIN_VALUE;
        	for (int i = 0; i < size; i++) {
        		TreeNode currNode = queue.poll();
        		max = Math.max(max, currNode.value);
        		if (currNode.left != null) queue.offer(currNode.left);
        		if (currNode.right != null) queue.offer(currNode.right);
        	}
        	list.add(max);
        }
        return list;
    }
}
