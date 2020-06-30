import java.util.HashMap;
import java.util.Map;

//303. Range Sum Query - Immutable
//https://leetcode.com/problems/range-sum-query-immutable/solution/
public class NumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		-2, 0, 3, -5, 2, -1
		NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
		System.out.println(numArray.sumRange(2, 5));
	}

//	private int[] nums;
//	private Map<String, Integer> map = new HashMap<>();
////	private Map<Pair<Integer, Integer>, Integer> map2 = new HashMap<>();
//		
//	NumArray(int[] nums) {
//		this.nums = nums;
//		for (int i=0; i<nums.length;i++) {
//			int sum = 0;
//			for (int j=i; j<nums.length;j++) {
//				sum = sum + nums[j];
//				map.put(i+"_"+j, sum);
//			}
//		}
//	}
//
//	 public int sumRange(int i, int j) {
//	     return map.get(i+"_"+j);
//	 }
	
	private int[] sum;

	public NumArray(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
}
