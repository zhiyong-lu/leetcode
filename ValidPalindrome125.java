
public class ValidPalindrome125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome("0P");
	}
	
	 public static boolean isPalindrome(String s) {
		 if (s == null || s.length() == 0) return false;
		 
		 int left = 0, right = s.length() - 1;
		 s = s.toLowerCase();
		 while (left < right) {
			 if (isAlphanumeric(s.charAt(left)) && isAlphanumeric(s.charAt(right))) {
				 if (s.charAt(left) != s.charAt(right)) return false;
			 } else if (isAlphanumeric(s.charAt(left))) {
				 right--;
				 continue;
			 } else if (isAlphanumeric(s.charAt(right))) {
				 left++;
				 continue;
			 } 
			 right--;
			 left++;
		 }
		 
		 return true;
	 }
	 
	 private static boolean isAlphanumeric(char c) {
		 if (c >= '0' && c <= '9') return true;
		 if (c >= 'a' && c <= 'z') return true;
		 if (c >= 'A' && c <= 'Z') return true;
		 return false;
	 }

}
