import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree297 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		
		String res = serialize(root);
		
		TreeNode newNode = deserialize(res);
		
		boolean b = identicalTrees(root, newNode);
	}
	
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	if (Objects.isNull(root))
			return "X,";
		
		String left = serialize(root.left);
		String right = serialize(root.right);
		
		return root.value + "," + left + right; //preorder
    }

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	String[] strArray = data.split(",");
    	Queue<String> queue = new LinkedList<>();
    	queue.addAll(Arrays.asList(strArray));
    	TreeNode newNode = deserializeHelper(queue);
    	return newNode;
    }

	private static TreeNode deserializeHelper(Queue<String> queue) {
		if (queue.isEmpty()) return null;
		
		String str = queue.poll();
		if (str.equalsIgnoreCase("X")) return null;
		TreeNode root = new TreeNode(Integer.valueOf(str));
		root.left = deserializeHelper(queue);
		root.right = deserializeHelper(queue);
		
		return root;
	}
	
	static boolean identicalTrees(TreeNode a, TreeNode b)  
    { 
        /*1. both empty */
        if (a == null && b == null) 
            return true; 
              
        /* 2. both non-empty -> compare them */
        if (a != null && b != null)  
            return (a.value == b.value 
                    && identicalTrees(a.left, b.left) 
                    && identicalTrees(a.right, b.right)); 
   
        /* 3. one empty, one not -> false */
        return false; 
    } 
   

}
