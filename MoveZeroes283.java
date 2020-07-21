//283. Move Zeroes

import java.util.Arrays;

public class MoveZeroes283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		moveZeroes(new int[] {0,1,0,3,12});
	}
	
//    public static void moveZeroes(int[] nums) {
//        if (nums.length <= 1) return; 
//    	int i = 0, j = 1;
//    	while (j < nums.length) {
//    		if (nums[i] == 0 && nums[j] != 0) {
//    			int temp = nums[i];
//    			nums[i] = nums[j];
//    			nums[j] = temp;
//    			i++;
//    		} else if (nums[i] != 0) {
//    			i++;
//    		}
//    		j++;
//    	}
//    	Arrays.stream(nums).forEach(System.out::println);
//    }
	
	public static void moveZeroes(int[] nums) {
		int i=0, j=1;
		
		while (j < nums.length) {
			if (nums[i] != 0) {
				i++;
			} else if (nums[i] == 0 && nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
			j++;
		}
	
	}
}
