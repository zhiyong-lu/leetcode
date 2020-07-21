import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//15. 3Sum
public class ThreeSum15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threeSum(new int[] {-1, 0, 1, 2, -1, -4});
	}
	
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.EMPTY_LIST;
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
        	int left = i+1;
        	int right = nums.length-1;
        	while (left < right) {
	        	if (nums[i] + nums[left] + nums[right] == 0) {
	        		List<Integer> newFound = new ArrayList<>();
	        		newFound.add(nums[i]);
	        		newFound.add(nums[left]);
	        		newFound.add(nums[right]);
	        		res.add(newFound);
	        		left = moveRight(nums, left+1);
	        		right = moveLeft(nums, right-1);
	        		while (nums[right] == nums[right+1]) {
	        			right--;
	        		}
	        	} else if (nums[i] + nums[left] + nums[right] > 0) {
	        		right--;
	        		while (nums[right] == nums[right+1]) {
	        			right--;
	        		}
	        	} else if (nums[i] + nums[left] + nums[right] < 0) {
	        		left++;
	        		while (nums[left] == nums[left-1]) {
	        			left++;
	        		}
	        	}
        	}
        	while (nums[i] == nums[i+1]) {
        		i = i+1;
        	}
        }
        return res;
    }
	
    static int moveLeft(int[] nums, int right) {
    	while (right==nums.length-1 || right>=0 && nums[right] == nums[right+1]) {
    		right--;
    	}
    	return right;
    }

    static int moveRight(int[] nums, int left) {
    	while (left == 0 || left <=nums.length-1 && nums[left] == nums[left-1]) {
    		left++;
    	}
    	return left;
    }
    
}
