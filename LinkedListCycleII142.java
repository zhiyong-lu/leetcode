// https://blog.csdn.net/willduan1/article/details/50938210
public class LinkedListCycleII142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static ListNode detectCycle(ListNode head) {
    	if( head == null || head.next == null ){
			return null;
		}
		// 快指针fp和慢指针sp，
        ListNode fp = head, sp = head;
        while( fp != null && fp.next != null){
        	sp = sp.next;
        	fp = fp.next.next;
        	//此处应该用fp == sp ，而不能用fp.equals(sp) 因为链表为1 2 的时候容易
        	//抛出异常
        	if( fp == sp ){  //说明有环
        		break;
        	}
        }
        //System.out.println( fp.val + "   "+ sp.val );
        if( fp == null || fp.next == null ){
        	return null;
        }
        //说明有环，求环的起始节点
        sp = head;
        while( fp != sp ){
        	sp = sp.next;
        	fp = fp.next;
        }
        return sp;
    }
}
