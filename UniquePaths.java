// 62. Unique Paths
public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = uniquePathsRecursive(7, 3);
	}
	
	private static int uniquePathsRecursive(int m, int n) {
		int[][] grid = new int[m][n];
		for (int j = 0; j < n; j++) {
			grid[0][j] = 1;
		}
		
		for (int i = 0; i < m; i++) {
			grid[i][0] = 1;
		}
		int[][] memo = new int[m][n];
		
		int result = helper(grid, m-1, n-1, memo);
		return result;
	}
	
	private static int helper(int[][] grid, int i, int j, int[][] memo) {
		if (i==0 || j==0) return grid[i][j];
		
		if (memo[i][j]!=0) 
			return memo[i][j];
		
		memo[i][j] = helper(grid, i-1, j, memo) + helper(grid, i, j-1, memo);
		
		return memo[i][j];
	}

	public static int uniquePathBest(int m, int n) {
		int[][] obstacleGrid = new int[m][n];
		
		int width = n;
		int[] dp = new int[width];
		
		dp[0] = 1;
		for (int[] row : obstacleGrid) {
			for (int j=0; j<width; j++) {
				if (row[j] == 1) {
					dp[j] = 0;
				} else if (j > 0) {
					dp[j] += dp[j-1];
				}
			}
		}
		return dp[width-1];
	}
	
//	https://www.cnblogs.com/grandyang/p/4353555.html
    public int uniquePaths1(int m, int n) {
    	int[][] dp = new int[m][n];
    	
    	for (int i=0;i<m;i++) {
    		dp[i][0] = 1;
    	}
    	
    	for (int j=0;j<n;j++) {
    		dp[0][j] = 1;
    	}
    	
    	for (int i=1; i<m; i++) {
    		for (int j=1;j<n;j++) {
    			dp[i][j] = dp[i][j-1]+dp[i-1][j];
    		}
    	}
    	
    	return dp[m-1][n-1];
    }
    
//    https://www.programcreek.com/2014/05/leetcode-unique-paths-java/
    public int uniquePathsMemo(int m, int n) {
    	int[][] memo = new int[m][n];
    	for (int i=0;i<m;i++) {
    		for (int j=0;j<n;j++) {
    			memo[i][j] = -1;
    		}
    	}
    	for (int i=0;i<m;i++) {
    		memo[i][0] = 1;
    	}
    	for (int j=0;j<n;j++) {
    		memo[0][j] = 1;
    	}
    	return uniquePathsMemoHelper(memo, m, n);
    }

    private int uniquePathsMemoHelper(int[][] memo, int m, int n) {
    	if (memo[m][n] != -1) {
    		return memo[m][n];
    	}
    	memo[m][n] = uniquePathsMemoHelper(memo, m-1, n) + uniquePathsMemoHelper(memo, m, n-1);
    	return memo[m][n] ;
    }
}
