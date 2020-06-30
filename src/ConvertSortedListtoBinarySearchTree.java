//109. Convert Sorted List to Binary Search Tree
public class ConvertSortedListtoBinarySearchTree {

	public static void main(String[] args) {
		

	}
	
//	private ListNode findMiddleElement(ListNode head) {
//
//	    // The pointer used to disconnect the left half from the mid node.
//	    ListNode prevPtr = null;
//	    ListNode slowPtr = head;
//	    ListNode fastPtr = head;
//
//	    // Iterate until fastPr reach the end of the linked list.
//	    while (fastPtr != null && fastPtr.next != null) {
//	      prevPtr = slowPtr;
//	      slowPtr = slowPtr.next;
//	      fastPtr = fastPtr.next.next;
//	    }
//
//	    // Handling the case when slowPtr was equal to head.
//	    if (prevPtr != null) {
//	      prevPtr.next = null;
//	    }
//
//	    return slowPtr;
//	  }
	
	private static ListNode findMid(ListNode head) {
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast!=null && fast.next!=null ) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (pre != null) {
			pre.next = null;
		}
		
		return slow;
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
    	if (head == null) return null;
    	
    	ListNode rootLN = findMid(head);
    	
    	TreeNode root = new TreeNode(rootLN.val);
    	
    	root.left = sortedListToBST(head);
    	root.right = sortedListToBST(rootLN.next);
    	
    	return root;
    }
}
