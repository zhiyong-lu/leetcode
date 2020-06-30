//4. Median of Two Sorted Arrays
public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = findMedianSortedArraysMe(new int[] {1, 2}, new int[] {3,4});
	}
	
	public static double findMedianSortedArraysMe(int[] nums1, int[] nums2) {
		if (nums1.length == 0 && nums2.length > 0) {
			return getMedium(nums2);
		} else if (nums1.length > 0 && nums2.length == 0) {
			return getMedium(nums1);
		}
		
		int totalLen = nums1.length + nums2.length;
		int[] resultArrays = new int[totalLen];
		
		int index1 = 0;
		int index2 = 0;
		int iResult = 0;
		while (index1 < nums1.length && index2 < nums2.length) {
			if (nums1[index1] < nums2[index2]) {
				resultArrays[iResult++] = nums1[index1++];
			} else if (nums1[index1] > nums2[index2]) {
				resultArrays[iResult++] = nums2[index2++];
			}
		}
		
		if (index1 == nums1.length) {
			while (iResult < totalLen) {
				resultArrays[iResult++] = nums2[index2++];
			}
		} else if (index2 == nums2.length) {
			while (iResult < totalLen) {
				resultArrays[iResult++] = nums1[index2++];
			}
		}
		
		return getMedium(resultArrays);
	}
	
	private static double getMedium(int[] nums) {
		int index = nums.length / 2;
		boolean isOdd = nums.length % 2 == 0? false:true;
		
		if (isOdd) {
			return (double)nums[index];
		} else {
			return ((double) (nums[index - 1] + nums[index])) / 2;
		}
		
	}
	
//	https://www.cnblogs.com/grandyang/p/4465932.html
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

}
