
public class JumpGame55 {

	public static void main(String[] args) {
		canJumpGreedy(new int[] {2, 3, 1, 1, 4});

	}
	
    public static boolean canJumpGreedy(int[] nums) {
        if (nums == null) 
        	return false;
        
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
        	if (nums[i] + i >= endReachable) {
        		endReachable = i;
        	}
        }
        return endReachable == 0;
    }
    
//    https://www.youtube.com/watch?v=r3pZd9ghqxk
    public static boolean canJumpGreedyWang(int[] nums) {
    	if (nums.length <= 1) return true;
    	
    	int reach = 0;
    	for (int i=0; i <nums.length && i <= reach; i++) {
    		reach = Math.max(reach, nums[i] + i);
    		if (reach >= nums.length - 1) return true;
    	}
    	
    	return false;
    }

}
