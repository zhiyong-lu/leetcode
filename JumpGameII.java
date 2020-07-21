
public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	https://www.youtube.com/watch?v=r3pZd9ghqxk
    public static int jump(int[] nums) {
    	if (nums == null || nums.length <= 1) return 0;
    	
        int index = 0, step = 0, currMaxIndex = 0, nextMaxIndex = 0;
    	
        while (index <= currMaxIndex) {
        	while (index <= currMaxIndex) {
        		nextMaxIndex = Math.max(nextMaxIndex, nums[index] + index);
        		index++;
        	}
        	currMaxIndex = nextMaxIndex;
        	step++;
        	if (currMaxIndex >= nums.length - 1) return step;
        }
        
        return 0;
    }
}
