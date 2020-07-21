import java.util.Arrays;

public class PerfectSquares279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        for (int slotNumber = 1; slotNumber <= n; slotNumber++) {
        	for (int j = 1; j * j <= slotNumber; j++) {
        		dp[slotNumber] = Math.min(dp[slotNumber], dp[slotNumber - j * j] + 1);
        	}
        }
        
        return dp[n];
    }

}
