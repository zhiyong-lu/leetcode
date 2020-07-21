//108. Convert Sorted Array to Binary Search Tree

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public static TreeNode sortedArrayToBST(int[] nums) {
    	return helper(nums, 0, nums.length-1);
    }

	private static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) return null;
		
		int rootIndex = (right-left)/2;
		TreeNode root = new TreeNode(nums[rootIndex]);
//		if (left == right) 
//			return root;
		
		root.left = helper(nums, left, left+rootIndex-1);
		root.right = helper(nums, left+rootIndex+1, right);
		
		return root;
	}

}
