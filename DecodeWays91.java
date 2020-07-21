
public class DecodeWays91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="230";
		numDecodings(s);
	}
	
    public static int numDecodings(String s) {
    	if (s == null || s.length() == 0) return 0;
    	if (s.charAt(0) == '0') return 0;
        
    	// state and init
    	int previousWays = 1; // s.charAt(0)
    	int currentWays = 1; //  s.charAt(1)
    	
    	// transition function
    	
    	for (int i = 1; i < s.length(); i++) {
    		int tempWays = currentWays;
    		if (s.charAt(i) == '0') {
    			currentWays = previousWays;
    			if (s.charAt(i - 1) > '2' || s.charAt(i - 1) <= '0') {
    				return 0;
    			}
    		} else if (s.charAt(i - 1) != '0' && Integer.valueOf(s.substring(i-1, i+1)) <= 26) {
    				currentWays = currentWays + previousWays;
    		}
    		previousWays = tempWays;
    	}
    	return currentWays;
    }
}
