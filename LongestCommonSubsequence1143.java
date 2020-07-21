
public class LongestCommonSubsequence1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer x =Integer.valueOf(9);
		Double y = Double.valueOf(9);
		
		int result = longestCommonSubsequence("abcde", "ace");
	}
	
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for (int i = 0; i < len1; i++) {
        	for (int j = 0; j < len2; j++) {
        		char char1 = text1.charAt(i), char2 = text2.charAt(j);
        		
        		if (char1 == char2) {
        			dp[i+1][j+1] = dp[i][j] + 1;
        		} else {
        			dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
        		}
        	}
        }
        return dp[len1][len2];
    }

}
