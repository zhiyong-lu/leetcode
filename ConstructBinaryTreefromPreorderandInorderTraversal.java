import java.util.Arrays;

//105. Construct Binary Tree from Preorder and Inorder Traversal

//https://www.cnblogs.com/grandyang/p/4296500.html
public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//    	int pLeft = 0;
//    	int pRight = preorder.length-1;
//    	int iLeft = 0;
//    	int iRight = inorder.length-1;
//    	return helper(preorder, pLeft, pRight, inorder, iLeft, iRight);
//    }
//
//	private static TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
//		if (pLeft > pRight || iLeft > iRight) return null;
//		
//		int rootIndex = findRootIndexInInorder(preorder[pLeft], inorder);
//		TreeNode root = new TreeNode(preorder[pLeft]);
//		root.left = helper(preorder, pLeft+1, pLeft+(rootIndex-iLeft), inorder, iLeft, rootIndex-1);
//		root.right = helper(preorder, pLeft+(rootIndex-iLeft)+1, pRight, inorder, rootIndex+1, iRight);
//		
//		return root;
//	}
//
//	private static int findRootIndexInInorder(int rootValue, int[] inorder) {
//		for (int i=0; i<inorder.length;i++) {
//			if (rootValue == inorder[i])
//				return i;
//		}
//		
//		return 0;
//	}
	
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int pLeft = 0, pRight = preorder.length - 1;
		int iLeft = 0, iRight = inorder.length - 1;
		
		TreeNode root = helper(preorder, pLeft, pRight, inorder, iLeft, iRight);
		
		return root;		
	}

	private static TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
		if (pLeft > pRight || iLeft > iRight)
			return null;
		
		int iIndex = Arrays.binarySearch(inorder, preorder[pLeft]);
		
		TreeNode root = new TreeNode(preorder[pLeft]);
		
		root.left = helper(preorder, pLeft + 1, pLeft + (iIndex - iLeft), inorder, iLeft, iIndex - 1);
		root.right = helper(preorder, pLeft + (iIndex - iLeft) + 1, pRight, inorder, iIndex +1, iRight);
		
		return root;
	}

}
