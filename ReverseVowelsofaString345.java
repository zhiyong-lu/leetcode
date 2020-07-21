
public class ReverseVowelsofaString345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reverseVowels("abcdef");
	}
	
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
    	
    	char[] chars = s.toCharArray();
    	
    	int left = 0, right = chars.length - 1;
    	
    	while (left < right) {
    		if (isVowel(chars[left]) && isVowel(chars[right])) {
    			char temp = chars[left];
    			chars[left] = chars[right];
    			chars[right] = temp;
    		} else if (isVowel(chars[left])) {
    			right--;
                continue;
    		} else if (isVowel(chars[right])) {
    			left++;
                continue;
    		}
            right--;
            left++;

        }
        return String.valueOf(chars);
    }
    
    private static boolean isVowel(char c) {
    	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
