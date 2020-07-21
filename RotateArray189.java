import java.util.Arrays;

public class RotateArray189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rotate(new int[] {1,2,3,4,5,6,7}, 3);
	}
	
    public static void rotate(int[] nums, int k) {
        int temp = 0;
        for (int i=0; i < k; i++) {
        	temp = nums[nums.length - 1];
        	for (int j = nums.length - 1; j > 0; j--) {
        		nums[j] = nums[j-1];
        	}
        	nums[0] = temp;
        }
        
//        System.out.println(Arrays.toString(nums));
    }
    
    public static void rotate2(int[] nums, int k) {
    	reverse(nums, 0, nums.length - 1);
    	reverse(nums, 0, k - 1);
    	reverse(nums, k, nums.length-1);
//        System.out.println(Arrays.toString(nums));
    }

	private static void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
			i++;
			j--;
		}
	}
}
