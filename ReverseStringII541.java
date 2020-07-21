
public class ReverseStringII541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseStr("abcdefg", 8);
	}
	
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < s.length(); i = i + 2*k) {
        	reverse(chars, i, Math.min(i + k - 1, chars.length - 1));
        }
        
        return String.valueOf(chars);
    }
    
    private static void reverse(char[] chars, int i, int j) {
    	while (i < j) {
    		char temp = chars[i];
    		chars[i++] = chars[j];
    		chars[j--] = temp;
    	}
    }

}
