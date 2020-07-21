import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(7);
		
		connectUsingDummy(root);
	}
	
//	http://rainykat.blogspot.com/2017/02/leetcodef-117-populating-next-right.html
//	Complexity: time O(N) space O(N) - queue
	 public static void connectBST(Node root) {
		 Queue<Node> queue = new LinkedList<>();
		 
		 queue.offer(root);
		 while (!queue.isEmpty()) {
			 int size = queue.size();
			 for (int i=0; i<size; i++) {
				 Node curNode = queue.poll();
				 if (i<size-1) {
					 curNode.next = queue.peek();
				 }
				 if (curNode.left != null) queue.offer(curNode.left);
				 if (curNode.right != null) queue.offer(curNode.right);
			 } 
		 }
		 
	 }
	
//	 https://www.cnblogs.com/grandyang/p/4290148.html
	 public static void connectUsingDummy(Node root) {
	        Node dummy = new Node(0);
	        Node cur = dummy;//record next root
	        while(root != null){
	            if(root.left != null){
	            	cur.next = root.left;
	            	cur = cur.next;
	            } // if
	            
	            if(root.right != null){
	            	cur.next = root.right;
	            	cur = cur.next;
	            } // if
	            
	            root = root.next;//reach end, update new root & reset dummy
	            if(root == null){
	                root = dummy.next;
	                cur = dummy;
	                dummy.next = null;
	            } // if
	        } // while
	}
    
    public static void connect(Node root) {
        if(root == null) 
            return;
     
        Node prevousLevelHead = root;//prevous level's head 
        Node prevousLevelCurrentPointer = null;//previous level's pointer
        Node currentLevelHead = null;//currnet level's head 
        Node currentLevelPointer = null;//current level's pointer
     
        while(prevousLevelHead!=null){
        	prevousLevelCurrentPointer = prevousLevelHead;
     
            while(prevousLevelCurrentPointer!=null){
                //left child is not null
                if(prevousLevelCurrentPointer.left!=null)    {
                    if(currentLevelHead == null){
                    	currentLevelHead = prevousLevelCurrentPointer.left;
                    	currentLevelPointer = prevousLevelCurrentPointer.left;
                    }else{
                    	currentLevelPointer.next = prevousLevelCurrentPointer.left;
                    	currentLevelPointer = currentLevelPointer.next;
                    }
                }
     
                //right child is not null
                if(prevousLevelCurrentPointer.right!=null){
                    if(currentLevelHead == null){
                    	currentLevelHead = prevousLevelCurrentPointer.right;
                    	currentLevelPointer = prevousLevelCurrentPointer.right;
                    }else{
                    	currentLevelPointer.next = prevousLevelCurrentPointer.right;
                    	currentLevelPointer = currentLevelPointer.next;
                    }
                }
     
                prevousLevelCurrentPointer = prevousLevelCurrentPointer.next;
            } // while
     
            //update last head
            prevousLevelHead = currentLevelHead;
            currentLevelHead = null;
        }
    }

}
