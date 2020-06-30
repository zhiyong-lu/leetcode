import java.util.Arrays;

//322. Coin Change
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coinChangeIterative(new int[] {1, 2, 5}, 11);
//		coinChangeIterative(new int[] {2}, 3);
	}
	
//	https://www.youtube.com/watch?v=EM9YWv1hBSk
	public static int coinChangeRecursive(int[] coins, int amount) {
		int[] memo = new int[amount+1];
		int result  = helper(coins, amount, memo);
		return result;
	}

	private static int helper(int[] coins, int amount, int[] memo) {
		if (amount == 0) {
			memo[amount] = 0;
			return 0;
		}
		int count = amount;
		int res = Integer.MAX_VALUE - 1;
		for (int coin:coins) {
			if (amount >= coin) {
				count = helper(coins, amount-coin, memo) + 1;
				if (count == 0)
					continue;
				else {
					res = Math.min(res, count);
				}					
			}
		}
		
		if (res == Integer.MAX_VALUE - 1) {
			memo[amount] = -1;
			return -1;
		}
		
		return memo[amount] = res;
	}
	
	public static int coinChangeIterative(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		Arrays.fill(dp, 1, amount+1, Integer.MAX_VALUE-1);
//		dp[0] = 0;
		
	
		for (int i=0; i < amount; ++i) {
			for (int coin : coins) {
				if ((i+coin) <= amount)
					dp[i+coin] = Math.min(dp[i+coin], dp[i]+1);
			}
		}
		return  dp[amount];
	}
	

//	public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];//0,1,2,..,amount
//        for(int i = 1; i <= amount; i++){
//            int count = -1;
//            //key is min count, all solutions must be generated from existing coin
//            for(int coin : coins) {
//             if(i >= coin && dp[i-coin]!=-1) {//skip non-existing solution
//              int cur = dp[i-coin]+1;
//              if(count < 0)
//                  count  = cur;
//              else if(cur < count)
//                  count = cur;
//             }
//         }
//         dp[i] = count;
//        }
//        return dp[amount];
//    }
}
