
public class MaximumSubarray53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {-1,-2};
		
		int res = maxSubArray(nums);
	}

    public static int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        int currTotal = nums[0];
        int currMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	currTotal = Math.max(nums[i], currTotal + nums[i]);
        	currMax = Math.max(currTotal, currMax);
        }
        
        return currMax;
    }
    
//    public static int maxSubArrayAgain(int[] nums) {
//    	
//    }
}
