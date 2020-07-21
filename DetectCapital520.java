
public class DetectCapital520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		detectCapitalUse("aaa");
	}

	public static boolean detectCapitalUse(String word) {
		if (word == null || word.length() == 0) return false;
		
		int uppcaseTotal = 0, lowercaseTotal = 0;
		
		for (char c : word.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				lowercaseTotal++;
			} else {
				uppcaseTotal++;
			}
		}
		
		if (uppcaseTotal == word.length()) return true;
		if (lowercaseTotal == word.length()) return true;
		if (uppcaseTotal == 1 && isUppercase(word.charAt(0))) return true;
		
		return false;
			    
	}
	
	private static boolean isUppercase(char c) {
		if (c >= 'A' && c <= 'Z') return true;
		return false;
	}
	
	

}
