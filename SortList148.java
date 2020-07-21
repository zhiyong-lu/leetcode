
public class SortList148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode temp = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
        	temp = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        temp.next = null;
        
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(slow);
        
        ListNode res = merge(leftNode, rightNode);
        
        return res;
    }

	private static ListNode merge(ListNode leftNode, ListNode rightNode) {
		ListNode sortedTempHead = new ListNode(0);
		ListNode currentNode = sortedTempHead;
		
		while (leftNode != null && rightNode != null) {
			if (leftNode.val < rightNode.val) {
				currentNode.next = leftNode;
				leftNode = leftNode.next;
			} else {
				currentNode.next = rightNode;
				rightNode = rightNode.next;
			}
			currentNode = currentNode.next;
		}
		
		if (leftNode != null) {
			currentNode.next = leftNode;
//			leftNode = leftNode.next;
		}
		
		if (rightNode != null) {
			currentNode.next = rightNode;
//			rightNode = rightNode.next;
		}
		
		return sortedTempHead.next;
	}
}
