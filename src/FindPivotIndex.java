
public class FindPivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = pivotIndex(new int[] {1, 2, 3});
	}
	
//	724. Find Pivot Index
    public static int pivotIndexMe(int[] nums) {
        int left=0, right = nums.length-1;
        int leftSum = nums[left];
        int rightSum = nums[right];
        while (left < right) {
        	if (leftSum < rightSum) {
        		left++;
        		leftSum += nums[left];
        	} else if (leftSum > rightSum) {
        		right--;
        		rightSum += nums[right];
        	} else if (leftSum == rightSum) {
        		if (left == right - 2 ) {
        			return left+1;
        		} else {
        			break;
        		}
        	}
        }
        return -1;
    }
    
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

}
