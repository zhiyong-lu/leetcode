import java.util.ArrayDeque;
import java.util.Deque;


//https://xuyiruan.com/2019/02/06/Lowest-Common-Ancestor-Series/
public class LowestCommonAncestorofaBinarySearchTree235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
	
	public TreeNode lowestCommonAncestorIterativeWithQueue1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (p.value < node.value && q.value < node.value) {
                queue.offer(node.left);
            } else if (p.value > node.value && q.value > node.value) {
                queue.offer(node.right);
            } else {
                return node;
            }
        }
        return null;
    }
	
	public TreeNode lowestCommonAncestorIterativeW2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true) {
            if (p.value < node.value && q.value < node.value) {
                node = node.left;
            } else if (p.value > node.value && q.value > node.value) {
                node = node.right;
            } else {
                break;
            }
        }
        return node;
    }
	
	public TreeNode lowestCommonAncestorZZZ(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.value == p.value || root.value == q.value) return root;
		
		if (root.value > p.value && root.value > q.value) 
			return lowestCommonAncestorZZZ(root.left, p, q);
		else if (root.value < p.value && root.value < q.value) 
			return lowestCommonAncestorZZZ(root.right, p, q);
		
		return root;
	}
	
}
