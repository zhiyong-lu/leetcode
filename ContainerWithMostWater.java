//11. Container With Most Water
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxArea(new int[] {1,8,6,2,5,4,8,3,7});
	}
	
//    public int maxArea(int[] height) {
//    	int left = 0;
//    	int right = height.length;
//        int max = 0;
//        
//    	while (left < right) {
//    		Math.min(height[left], height[right]);
//    		
//    	}
//    }
	
    public static int maxArea(int[] height) {
       int left = 0, right = height.length - 1;
       int max = Integer.MIN_VALUE;
       while (left < right) {
    	   if (height[left] <= height[right]) {
    		   max = Math.max(max, (Math.min(height[left], height[right])*(right - left)));
    		   left++;
    	   } else {
    		   max = Math.max(max, (Math.min(height[left], height[right])*(right - left)));
    		   right--;
    	   }
       }
       return max;
    }

}
