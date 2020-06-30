//11. Container With Most Water
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maxArea(int[] height) {
    	int left = 0;
    	int right = height.length;
        int max = 0;
        
    	while (left < right) {
    		Math.min(height[left], height[right]);
    		
    	}
    }

}
