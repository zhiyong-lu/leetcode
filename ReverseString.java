import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseString(new char[] {'h','e','l','l','o'});
	}
	
    public static void reverseString(char[] s) {
//    	char[] output = new char[s.length]; 
    	helper(0, s);
    }

	private static void helper(int i, char[] s) {
		if (i>=s.length || s==null) return;
		
		helper(i+1, s);
		char temp = s[s.length - 1 - i];
		s[s.length - 1 - i] = s[i];
		s[i] = temp;
	}
    
    
}
