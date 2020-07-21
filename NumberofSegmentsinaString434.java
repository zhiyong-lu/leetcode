
public class NumberofSegmentsinaString434 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = countSegments("  Hello, my name is John  ");
	}
	
    public static int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int count = 0;
        char previous = s.charAt(0);
        char curr = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
        	curr = s.charAt(i);
        	if (curr == ' ' && previous != ' ') {
        		count++;
        	}
        	previous = curr;
        }
    	
    	return previous == ' ' ? count : count + 1;
    }    
    
    public static int countSegmentsLeetcode(String s) {
    	 int segmentCount = 0;

         for (int i = 0; i < s.length(); i++) {
             if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                 segmentCount++;
             }
         }

         return segmentCount;
    }

}
