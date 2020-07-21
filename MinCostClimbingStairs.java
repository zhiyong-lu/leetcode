import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCostClimbingStairs {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		largeGroupPositions("abcdddeeeeaabbbcd");
		
		System.out.println(maxDistToClosest(new int[] {1,0,0,0,1,0,1}));
	}
	
//	 70. Climbing Stairs
	public int climbStairsMeOne(int n) {
       int preStairNeeded = 1;
       int currNeeded = 1;

       while (n-- > 0) {
    	   currNeeded = currNeeded + preStairNeeded;
    	   preStairNeeded = currNeeded - preStairNeeded;
       }

       return preStairNeeded;
    }
	
	public int climbStairsMeRecursive(int n) {
		int[] memo = new int[n+1];
		return recursiveHelper(n, memo);
	}
	
	public int recursiveHelper(int n, int[] memo) {
		if (n < 1) return 1;
		
		if (memo[n] > 0) {
			return memo[n];
		}
		
		return memo[n] = recursiveHelper(n-1, memo) + recursiveHelper(n-2, memo);
	}
	
	
//	746. Min Cost Climbing Stairs
    public static int minCostClimbingStairsMe(int[] cost) {
        int len = cost.length;
        int[] totalCost = new int[len];
        totalCost[0] = cost[0];
        totalCost[1] = cost[1];
        
        for (int i=2; i<len;i++) {
        	totalCost[i] = cost[i] + Math.min(totalCost[i-1], totalCost[i-2]);
        }
        
        return Math.min(totalCost[len-1], totalCost[len-2]);
    }
    
    public static int minCostClimbingStairsRecursive(int[] cost) {
        return minCostClimbingStairsHelper(cost, cost.length);
    }

	private static int minCostClimbingStairsHelper(int[] cost, int i) {
		if (i<=1)
			return cost[i];
			
		return cost[i] + Math.min(minCostClimbingStairsHelper(cost, i-1), minCostClimbingStairsHelper(cost, i-2));
	}
	
//	830. Positions of Large Groups
    public static List<List<Integer>> largeGroupPositions(String S) {
//    	char[] charArray = S.toCharArray();
//    	char currChar = charArray[0];
    	int total = 1;
    	int j = 0;
//    	int[][] outputs = new int[S.length()][2];
    	List<List<Integer>> listss = new ArrayList<>();
    	
//    	for (int i=1;i<S.length();i++) {
//    		if (currChar == charArray[i]) {
//    			total++;
//    		} else if (currChar != charArray[i]) {
//    			if (total >=3) {
//    				List<Integer> lists = new ArrayList<>();
//    				lists.add(i - total);
//    				lists.add(i - 1);
//    				listss.add(lists);
//    			}
//    			total = 1;
//    			currChar = charArray[i];
//    		}
//      }
    	
    	char currChar = S.charAt(0);
    	for (int i=1; i<S.length(); i++) {
    		if (currChar == S.charAt(i)) {
    			total++;    			
    		} else if (currChar != S.charAt(i)) {
    			if (total>=3) {
    				listss.add(Arrays.asList(new Integer[] {i-total, i-1}));
    			}
    			total=1;
    			currChar = S.charAt(i);
    		}
    	}
    	
    	return listss;
    }
    
//    849. Maximize Distance to Closest Person
    public static int maxDistToClosest(int[] seats) {
        int N = seats.length;
        int[] left = new int[N], right = new int[N];
        Arrays.fill(left, N);
        Arrays.fill(right, N);

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i-1] + 1;
        }

        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            else if (i < N-1) right[i] = right[i+1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }

}
