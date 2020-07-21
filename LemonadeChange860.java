
public class LemonadeChange860 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
    	
    	for (int bill : bills) {
        	if (bill == 5) 
        		five++;
        	else if (bill == 10) {
        		ten++;
        		five--;
        	}
        	else if (bill == 20) {
        		if (ten > 0) {
        			ten--;
        			five--;
        		} else {
        			five -= 3;
        		}
        	}
    	}	
    	if (five < 0) return false;
    	return true;        		
    }
}
