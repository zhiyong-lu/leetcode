//https://www.cnblogs.com/grandyang/p/4059650.html
public class MergeSortedArray88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (i >= 0 && j >= 0) {
        	if (nums1[i] < nums2[j]) {
        		nums1[k--] = nums2[j--];
        	} else {
        		nums1[k--] = nums1[i--];
        	}
        }
        
        while (j >= 0) {
        	nums1[k--] = nums2[j--];
        }
    }
}
