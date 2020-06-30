import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199. Binary Tree Right Side View

//https://www.cnblogs.com/grandyang/p/4051321.html

//DFS ?

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		
		rightSideView(root);
		
	}
	
    public static List<Integer> rightSideView(TreeNode root) {
//    	Queue<TreeNode> queue = new LinkedList<>();
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	List<Integer> list = new ArrayList<>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
//    		list.add(queue.peek().value);
    		list.add(queue.peekLast().value);
    		for (int i=queue.size(); i>0; --i) {
	    		TreeNode currNode = queue.poll();
	    		
	    		if (currNode.left!=null)
	    			queue.offer(currNode.left);
	    		
	    		if (currNode.right!=null)
	    			queue.offer(currNode.right);
    		}
    	}
        return list;
    }

}
