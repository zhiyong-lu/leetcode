
public class RemoveDuplicatesfromSortedArray26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeDuplicates(new int[] {1,1,2});
	}
	
    public static int removeDuplicates(int[] nums) {
        int right = 0;
        int left = 0;
    	while (left < nums.length) {
    		if (nums[right] == nums[left]) {
    			left++;
    		} else {
    			right++;
    			nums[right] = nums[left];
    			left++;
    		}
    	}
    	return right+1;
    }

}
