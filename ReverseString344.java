
public class ReverseString344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        
        int left = 0, right = s.length - 1;
        
        while (left < right ) {
        	char temp = s[left];
        	s[left] = s[right];
        	s[right] = temp;
        	right--;
        	left++;
        }
    }
	
}
