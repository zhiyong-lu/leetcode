//121. Best Time to Buy and Sell Stock
public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int result = maxProfit(new int[] {7,6,4,3,1});
	}
	
//    public static int maxProfit(int[] prices) {
//    	int lowest = prices[0];
//    	int max = 0;
//    	for (int i=1; i<prices.length; ++i) {
//    		lowest = Math.min(lowest, prices[i]);
//    		if (lowest != prices[i]) {
//    			max = Math.max(max, prices[i] - lowest);
//    		}
//    	}
//        return max;
//    }
	
	public static int maxProfit(int[] prices) {
		int max = 0, lowest = Integer.MAX_VALUE;
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < lowest)
				lowest = prices[i];
			else {
				max = Math.max(max, prices[i] -lowest);
			}
		}
		return max;
	}

}
