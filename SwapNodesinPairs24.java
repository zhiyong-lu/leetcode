import java.util.Arrays;

//24. Swap Nodes in Pairs

/*
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
*/
//https://www.cnblogs.com/grandyang/p/4441680.html
public class SwapNodesinPairs24 {

	public static void main(String[] args) {
		
		int[][] dp = new int[3][2];
		for (int i=0; i<3; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		
		
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode resultI = swapPairsIterative(head);
		ListNode resultR = swapPairsRecursive(head);
	}
	
	private static ListNode swapPairsRecursive(ListNode head) {
		if (head == null || head.next == null) return null;
		
		ListNode temp = head.next;
		head.next = swapPairsRecursive(head.next.next);
		temp.next = head;
		
		return temp;
	}

	public static ListNode swapPairsIterative(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode previous = dummy;
		dummy.next = head;
		
		while (previous.next != null && previous.next.next != null) {
			ListNode temp = previous.next.next; //1
			previous.next.next = temp.next; //2
			temp.next = previous.next; //3
			previous.next = temp; //4
			previous = temp.next; //5
		}
		return dummy.next;
	}

}
