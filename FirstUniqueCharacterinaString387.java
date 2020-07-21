

public class FirstUniqueCharacterinaString387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int firstUniqChar(String s) {
       if (s == null || s.length() == 0) return -1;
       int[] map = new int[256];
       
       for (char c : s.toCharArray()) {
    	   map[c]++;
       }
       
       for (int i = 0; i< s.length(); i++) {
    	   if (map[s.charAt(i)] == 1) {
    		   return i;
    	   }    		   
       }
       
       return -1;
    }

}
