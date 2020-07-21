import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	https://www.youtube.com/watch?v=fbkvdWUS5Ic
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
        	return new int[0];
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        
        for (int i = 0; i <= nums.length; i++) {
        	if (!deque.isEmpty() && deque.peekFirst() == i - k) {
        		deque.pollFirst();
        	}
        }
        
        
        
    }

}
