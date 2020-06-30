
public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testIndexOf = strStr("hello", "ll");
		System.out.print(testIndexOf);
	}
	
    public static int strStr(String haystack, String needle) {
        int i=0, j=0;

    	while (i<needle.length() && j<=haystack.length()-needle.length()) {
    		if (haystack.charAt(j) != needle.charAt(i)) {
    			i=0;
    		} else {
    			i++;
    		}
    		j++;
    	}
    	
    	return i==needle.length()? j-i:-1;
    }
    
//  58. Length of Last Word
    public static int lengthOfLastWord1(String str) {
//        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    	int len = str.length();
    	int count = 0;
    	
    	while (len > 0 && str.charAt(len-1) == ' ') {
    		len--;
    	}
    	
    	while (len >0 && str.charAt(len-1) != ' ') {
    		count++;
    		len--;
    	}
    	
    	return count;
    }
    
    
    public static int lengthOfLastWord2(String str) {
	  	int count = 0;
	  	
	  	for (int i=str.length()-1; i>=0; i--) {
	  		if (str.charAt(i) == ' ') {
	  			if (count != 0)
	  				return count;
	  		} else {
	  			count++;
	  		}
	  			
	  	}
	  	return count;
  }

}
