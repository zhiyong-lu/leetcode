
public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rotated = new int[] {4,5,6,7,0,1,2};
		int index = findPivot(rotated);
//		int result = search(rotated, 0);
	}
	
//    public static int search(int[] nums, int target) {
//        int pivotIndex = findPivot(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        if (nums[pivotIndex] > target) {
//        	left = pivotIndex;
//        } else {
//        	right = pivotIndex;
//        }
//        
//        while (left < right) {
//        	
//        }
//    }

	private static int findPivot(int[] nums) {
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid-1;
			}
		}
		
		return right;
	}
	
	
	
	
//    public static int search(int[] nums, int target) {
//    	int index = findPivot(nums);
//		if (nums[index-1] >= target && nums[0] <= target) {
//			return find(nums, 0, index-1, target); 
//		} else {
//			return find(nums, index, nums.length-1, target);
//		}
//    }
//
//	private static int find(int[] nums, int left, int right, int target) {
//		while(left < right) {
//			int mid = left + (right-left)/2;
//			if (nums[mid]==target)
//				return mid;
//			else if (nums[mid] < target) {
//				left = mid+1;
//			} else {
//				right = mid;
//			}
//		}
//		return -1;
//	}
//
//	private static int findPivot(int[] nums) {
//		int left = 0;
//		int right = nums.length-1;
//		
//		while (left<right) {
//			int mid = left + (right-left)/2;
//			if (nums[left]>nums[right])
//				left=mid+1;
//			else 
//				right = mid;
//		}
//		
//		return right;
//	}

}
