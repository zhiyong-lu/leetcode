
public class ConvertSortedArraytoBinarySearchTree108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortedArrayToBST(new int[] {-10,-3,0,5,9});
	}
	
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0, nums.length - 1);
		return root;
    }

	private static TreeNode helper(int[] nums, int left, int right) {
		if (left > right) return null; 
		
		int mid = left + (right - left) / 2;
		
		TreeNode currNode = new TreeNode(nums[mid]);
		
		currNode.left = helper(nums, left, mid - 1);
		currNode.right = helper(nums, mid + 1, right);
		
		return currNode;
	}

}
