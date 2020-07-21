import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings647 {
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countSubstrings2("fdsklf");
	}
	
    public static int countSubstrings(String s) {
        if (s == null) return 0;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
        	helper(s, i, i, list);
        	helper(s, i, i + 1, list);
        }
        list.forEach(System.out::println);
        return list.size();
    }

	private static void helper(String s, int i, int j, List<String> list) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			count++;
			list.add(s.substring(i, j+1));
			i--;
			j++;
		}
	}
	
	 public static int countSubstrings2(String s) {
		 if (s == null || s.length() == 0) return 0;
		 int count = 0;
		 List<String> list = new ArrayList<>();
		 
		 boolean[][] dp = new boolean[s.length()][s.length()];
		 
		 for (int i = s.length() - 1; i >= 0; i--) {
			 for (int j = i; j < s.length(); j++) {
				 if (s.charAt(i) == s.charAt(j)) {
					 dp[i][j] = (j - i <= 2) ? true : dp [i+1][j-1];
					 if (dp[i][j]) {
						 count++;
						 list.add(s.substring(i, j+1));
					 }
				 }
			 }
		 }
		 list.forEach(System.out::println);
		 return list.size();
	 }
}
