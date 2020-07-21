import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

//		ListNode l1 = new ListNode(1);
//		l1.next = new ListNode(8);
//		ListNode l2 = new ListNode(0);

		addTwoNumbers(l1, l2);
	}

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
    	
    	Deque<ListNode> queue1 = new ArrayDeque<>();
    	Deque<ListNode> queue2 = new ArrayDeque<>();
    	
    	ListNode currL1 = l1;
    	ListNode currL2 = l2;
    	while (currL1 != null) {
    		queue1.offer(currL1);
    		currL1 = currL1.next;
    	}
    	while (currL2 != null) {
    		queue2.offer(currL2);
    		currL2 = currL2.next;
    	}
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
    	while (!queue1.isEmpty() || !queue2.isEmpty()) {
    		int node1Val = !queue1.isEmpty() ? queue1.poll().val : 0;
    		int node2Val = !queue2.isEmpty() ? queue2.poll().val : 0;
    		int temp = node1Val + node2Val + carry;
    		sb.append(temp % 10);
    		carry = temp / 10;
    	}
    	
    	if (carry > 0) sb.append(carry);
    	
    	ListNode head = new ListNode();
    	ListNode currNode = head;
    	for (int i =  0; i < sb.length(); i++) {
    		currNode.next = new ListNode(sb.charAt(i) - '0');
    		currNode = currNode.next;
    	}
    	
    	return head.next;
    	
    }
	
}
