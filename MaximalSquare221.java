
public class MaximalSquare221 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
		char[][] matrix = new char[][] 
				{{'1','0','1','0','0'},
			     {'1','0','1','1','1'},
			     {'1','1','1','1','1'},
			     {'1','0','0','1','0'}};
		
		maximalSquare(matrix);
	}

//	https://www.youtube.com/watch?v=RElcqtFYTm0
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (matrix[i-1][j-1] == '1') {
        			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        return max * max;
    }

}
