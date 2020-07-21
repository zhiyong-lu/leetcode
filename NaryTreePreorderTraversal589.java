import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal589 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        stack.add(root);
        while (!stack.isEmpty()) {
        	Node currNode = stack.pop();
        	list.add(currNode.val);
        	
        	List<Node> currChildren = currNode.children;
        	for (int i = currChildren.size() - 1; i >= 0; i-- ) {
        		if (currChildren.get(i) != null) 
        			stack.push(currChildren.get(i));
        	}
        }
        return list;        
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
	}
}
