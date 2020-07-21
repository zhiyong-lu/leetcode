import java.util.Stack;

public class PalindromeLinkedList234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        Stack<ListNode> stack = new Stack<>();
        ListNode currNode = head;
        while (currNode != null) {
        	stack.push(currNode);
        	currNode = currNode.next;
        }
        
        while (!stack.isEmpty()) {
        	currNode = stack.pop();
        	if (currNode.val != head.val) 
        		return false;
        	else {
        		head = head.next;
        	}
        }
        return true;
    }

}
