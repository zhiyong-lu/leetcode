import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal429 {

	public static void main(String[] args) {
		Node1 root = new Node1(1);
		Node1 n3 = new Node1(3);
		Node1 n2 = new Node1(2);
		Node1 n4 = new Node1(4);
		root.children = new ArrayList<>();
		root.children.add(n3);
		root.children.add(n2);
		root.children.add(n4);
		Node1 n5 = new Node1(5);
		Node1 n6 = new Node1(6);
		n3.children = new ArrayList<>();
		n3.children.add(n5);
		n3.children.add(n6);
		
		levelOrder(root);
	}
	
    public static List<List<Integer>> levelOrder(Node1 root) {
        Queue<Node1> queue = new ArrayDeque<>();
        List<List<Integer>> lists = new ArrayList<>();
        
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		List<Integer> currList = new ArrayList<>();
    		int size = queue.size();
    		for (int i = 0; i < size; ++i) {
    			Node1 currNode = queue.poll();
    			currList.add(currNode.val);
    			for (Node1 child : currNode.children) {
    				if (child != null) queue.offer(child);
    			}
    		}
    		lists.add(currList);
    	}
    	return lists;
    }
}
