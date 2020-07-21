//https://www.youtube.com/watch?v=63i802XLgOM

public class MinimumWindowSubstring76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minWindow("ADOBECODEBANC", "ABC");
	}

//	https://www.youtube.com/watch?v=vvVe7qxOz9U
	public static String minWindow(String s, String t) {
		if (s == null || s.length() == 0) return "";
	    int[] map = new int[128];
	    
	    for (char c : t.toCharArray()) {
	    	map[c]++;
	    }
	    
	    int count = 0, minLen = Integer.MAX_VALUE, minStart = -1, minEnd = -1;
	    int lo = 0, hi = 0;
	    
	    for (hi = 0; hi <s.length(); hi++) {
	    	if (map[s.charAt(hi)] > 0) {
	    		count++;
	    	}
	    	
	    	map[s.charAt(hi)]--;
	    	
	    	if (count == t.length()) {
    			while (lo < hi && map[s.charAt(lo)] < 0) {
    				map[s.charAt(lo)]++;
    				lo++;
    			}
    			
    			if (minLen > hi - lo + 1) {
    	    		minLen = hi - lo + 1;
    	    		minStart = lo;
    	    		minEnd = hi + 1;
    	    	}
    	    	
    	    	map[s.charAt(lo)]++;
    	    	lo++;
    	    	count--;
	    	}
	    }
	    
	    return minStart == -1 ? "" : s.substring(minStart,  minEnd);
	}
}

