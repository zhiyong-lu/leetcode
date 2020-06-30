import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findMaxLength(new int[] {0,1,0,0,1,1,0});
	}

	private static int findMaxLength(int[] is) {
		
		
	}
	
//	public static int findMaxLength(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
//        int maxlen = 0, count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            count = count + (nums[i] == 1 ? 1 : -1);
//            if (map.containsKey(count)) {
//                maxlen = Math.max(maxlen, i - map.get(count));
//            } else {
//                map.put(count, i);
//            }
//        }
//        return maxlen;
//    }

}
