import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> a1 = new ArrayList<>(Arrays.asList(2));
		List<Integer> a2 = new ArrayList<>(Arrays.asList(3, 4));
		List<Integer> a3 = new ArrayList<>(Arrays.asList(6, 5, 7));
		List<Integer> a4 = new ArrayList<>(Arrays.asList(4, 1, 3, 8));
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		
		int res = minimumTotal(triangle);
	}
	
    public static int minimumTotal(List<List<Integer>> triangle) {
    	 int rows = triangle.size();
     	 int dp[][] = new int[rows+1][rows+1]; // state
//     	int[] dp = new int[rows + 1];
         
     	for (int i = rows - 1; i >= 0; i--) {
     		for (int j = 0; j <= i; j++) {
     			dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
     		}
     	}
     	
     	return dp[0][0];
    }

}

