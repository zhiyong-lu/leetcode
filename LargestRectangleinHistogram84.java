//84. Largest Rectangle in Histogram 

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeSet;

public class LargestRectangleinHistogram84 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeSet<Integer> tree = new TreeSet<Integer>(); 
        tree.add(10); 
        tree.add(5); 
        tree.add(8); 
        tree.add(1); 
        tree.add(11); 
        tree.add(3); 
	  
//	        System.out.println(tree.higher(5)); 
	        System.out.println(tree.higher(8)); 
//	        System.out.println(tree.size()); 
	}
//	https://www.youtube.com/watch?v=GYuBQacXr1A
//    public static int largestRectangleArea(int[] heights) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        int max = Integer.MIN_VALUE;
//        stack.push(-1);
//        
//        for (int i = 0; i < heights.length; i++) {
//        	while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
//        		Integer tempIndex = stack.pop();
//        		max = Math.max(max,  heights[tempIndex] * (i - stack.peek() - 1));
//        	}
//        	stack.push(i);
//        }
//        
//        while (stack.peek() != -1) {
//        	Integer tempIndex = stack.pop();
//        	max = Math.max(max, heights[tempIndex] * (heights.length - stack.peek() - 1));
//        }
//        
//        return max;
//    }

	// 07/10/2020
	public static int largestRectangleArea(int[] heights) {
		int max = Integer.MIN_VALUE; 
		Deque<Integer> stack = new ArrayDeque<>();
		 stack.push(-1);
		 
		 for (int i = 0; i < heights.length; i++) {
			 while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
				 max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
			 }
			 stack.push(i);
		 }
		 
		 while (stack.peek() != -1) {
			 max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
		 }
		 
		 return max;
	}
}
