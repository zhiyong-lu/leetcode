import java.util.List;
import java.util.ArrayList;

public class Combinations77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	https://blog.csdn.net/u010500263/article/details/18435495
//	https://www.youtube.com/watch?v=qzdTZWW1X8A
	
//	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
//        ArrayList<ArrayList<Integer>> combSet = new ArrayList<>();
//        ArrayList<Integer> comb = new ArrayList<>();
//        
//        if(n < k) return combSet;
//        helper(n, k, combSet, comb, 1);
//        return combSet;
//    }
//    
//    public void helper(int n, int k, ArrayList<ArrayList<Integer>> combSet, ArrayList<Integer> comb, int start){
//        // one possible combinition constructured
//        if(comb.size() == k){
//            combSet.add(new ArrayList<Integer> (comb));
//            return;
//        }
//        
//        else{
//            for(int i=start; i<=n; i++){// try each possibility number in current position
//                comb.add(i);
//                helper(n, k, combSet, comb, i+1); // after selecting number for current position, process next position
//                comb.remove(comb.size()-1); // clear the current position to try next possible number
//            }
//        }
//    }
	
	public static List<List<Integer>> combineRe(int n, int k) {
		List<List<Integer>> lists = new ArrayList<>();
		if (n < k) return lists;
		
		helper(n, k, lists, new ArrayList<Integer>(), 1);
		
		return lists;
    }
	
	
	private static void helper(int n, int k, List<List<Integer>> lists, List<Integer> arrayList, int start) {
		if (k == 0) {
			lists.add(new ArrayList<Integer>(arrayList));
		}
		
		for (int i = start; i <= n; i++) {
			arrayList.add(i);
			helper(n, k-1, lists, arrayList, i+1);
			arrayList.remove(arrayList.size()-1);
		}
	}
//	https://blog.csdn.net/u010500263/article/details/18435495
//	https://www.youtube.com/watch?v=qzdTZWW1X8A
//	https://www.programcreek.com/2014/03/leetcode-combinations-java/ ==>best
	public static List<List<Integer>> combineReZZZ(int n, int k) {
		List<List<Integer>> resList = new ArrayList<>();
		if (n < k || n < 0 || k < 0) return resList;
		
		int startNum = 1;
		List<Integer> currList = new ArrayList<>();
		
		combineHelper(n, k, startNum, currList, resList);
		
		return resList;
	}
	
	private static void combineHelper(int n, int k, int startNum, List<Integer> currList, List<List<Integer>> resList) {
		if (currList.size() == k) {
			resList.add(new ArrayList<Integer>(currList));
			return;
		}
		
		for (int i = startNum; i < n; i++) {
			currList.add(i);
			combineHelper(n, k, i+1, currList, resList);
			currList.remove(currList.size() - 1);
		}
	}

}
