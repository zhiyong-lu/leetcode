import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreePostorderTraversal590 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<Integer> postorder(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        Deque<Integer> list = new LinkedList<>();
        
        if (root != null) deque.push(root);
        while (!deque.isEmpty()) {
        	Node currNode = deque.pop();
        	if (currNode != null) {
	        	list.addFirst(currNode.val);
	        	
	        	for (Node node : currNode.children) {
	        		if (node != null) deque.push(node);
	        	}
        	}
        }

        return new LinkedList<Integer>(list);
    }
    
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
