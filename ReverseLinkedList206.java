//206. Reverse Linked List

public class ReverseLinkedList206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	https://www.cnblogs.com/grandyang/p/4478820.html
    public static ListNode reverseListIterative(ListNode head) {
        ListNode previous = null;
        ListNode temp;
        while (head != null) {
        	temp = head.next;
        	head.next = previous;
        	previous = head;
        	head = temp;
        }
    	return previous;
    }
    
    public static ListNode reverseListRecursive(ListNode head) {
    	if (head == null || head.next == null) 
    		return head;
    	
    	ListNode newHead = reverseListRecursive(head.next);
    	
    	head.next.next = head;
    	head.next = null;
    	
    	return newHead;
    }

}
