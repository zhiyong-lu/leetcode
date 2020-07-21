import java.util.Arrays;

public class UniquePathsII63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = (obstacleGrid[0][0] == 1) ? 0:1; 
		
		for (int i = 1; i < m; i++) {
			dp[i][0] = (obstacleGrid[i][0] == 1) ? 0:dp[i-1][0];
		}
		
		for (int i = 1; i < n; i++) {
			dp[0][i] = (obstacleGrid[0][i] == 1) ? 0:dp[0][i-1];
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0:dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
	}
	
	public static int uniquePathsWithObstaclesDFS(int[][] obstacleGrid) {
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

		int[][] memo = new int[m][n]; //state
		memo[0][0] = 1; //init
				
		int res = helperDFS(obstacleGrid, memo, m - 1, n - 1);
		
		return res;
	}

	private static int helperDFS(int[][] obstacleGrid, int[][] memo, int i, int j) {
		if (i < 0 || j < 0) return 0;
		
		if (obstacleGrid[i][j] > 0) return 0;
		
		if (memo[i][j] > 0) return memo[i][j];
		
		memo[i][j] = helperDFS(obstacleGrid, memo, i - 1, j) + helperDFS(obstacleGrid, memo, i, j - 1);
		
		return memo[i][j];
	}
	
	
//	sample https://soulmachine.gitbooks.io/algorithm-essentials/java/dfs/unique-paths-ii.html
//	 	private int[][] memo;
	    public int uniquePathsWithObstaclesDFSSample(int[][] obstacleGrid) {
	        int m = obstacleGrid.length,  n = obstacleGrid[0].length;
	        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

	        int[][] memo = new int[m][n]; // state
//	        memo[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1; // init
	        memo[0][0] = 1;
	        return dfs(obstacleGrid, m - 1, n - 1, memo);
	    }
	    
	     int dfs(int[][] obstacleGrid, int x, int y, int[][] memo) {
	        if (x < 0 || y < 0) return 0;

	        if (obstacleGrid[x][y] != 0) return 0;

	        if (x == 0 && y == 0) return memo[0][0]; 
	        if (memo[x][y] > 0) {
	            return memo[x][y];
	        } else {
	            return memo[x][y] = dfs(obstacleGrid, x - 1, y, memo) +
	                    dfs(obstacleGrid, x, y - 1, memo);
	        }
	    }
}
