import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        	int tempKey = target - nums[i];
        	if (map.containsKey(tempKey)) 
        		return new int[] {i, map.get(tempKey)};
        	map.put(nums[i], i);
        }
        
        return new int[0];
    }

}
