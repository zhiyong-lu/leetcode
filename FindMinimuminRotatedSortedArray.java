//153. Find Minimum in Rotated Sorted Array
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result  = findMinRecursive(new int[] {3,4,5,6,7,8,1,2});
	}
	
    public static int findMin(int[] nums) {
    	if (nums==null) return 0;
    	if (nums.length==1) return nums[0];
    	
    	int left = 0;
    	int right = nums.length-1;
    	
    	while (left < right) {
    		int mid = left + (right-left)/2;
    		if (nums[mid] > nums[right]) {
    			left = mid+1;
    		} else {
    			right = mid;
    		}
    	}
    	
    	return nums[right];
    }
    
    public static int findMinRecursive(int[] nums) {
    	int left=0;
    	int right=nums.length-1;
    	return helper(nums, left, right);
    }

	private static int helper(int[] nums, int left, int right) {		
		if (nums[left] <= nums[right]) 
			return nums[left];
		int mid=(left+right)/2;
		return Math.min(helper(nums, left, mid), helper(nums, mid+1, right));
	}

}
