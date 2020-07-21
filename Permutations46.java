import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//46. Permutations
//https://www.youtube.com/watch?v=43w8tXWKSLw
public class Permutations46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> resLists = new ArrayList<>();

    	if (nums == null || nums.length == 0) return resLists;
    	
    	List<Integer> currList = new ArrayList<>();
    	Set<Integer> visitedSet = new HashSet<>();
    	
    	helper(nums, resLists, currList, visitedSet);
    	
        return resLists;
    }

	private static void helper(int[] nums, List<List<Integer>> resLists, List<Integer> currList, Set<Integer> visitedSet) {
		if (currList.size() == nums.length) 
			resLists.add(new ArrayList<>(currList));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (!visitedSet.contains(nums[i])) {
					currList.add(nums[i]);
					visitedSet.add(nums[i]);
					helper(nums, resLists, currList, visitedSet);
					visitedSet.remove(nums[i]);
					currList.remove(currList.size() - 1);
				}
			}
		}
	}

}
