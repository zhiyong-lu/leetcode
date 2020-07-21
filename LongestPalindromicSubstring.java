// https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/?ref=rp
public class LongestPalindromicSubstring {
	// Java DP Solution 
	
		// A utility function to print a substring str[low..high] 
		static void printSubStr(String str, int low, int high) { 
			System.out.println(str.substring(low, high + 1)); 
		} 

		// This function prints the longest palindrome substring 
		// of str[]. 
		// It also returns the length of the longest palindrome 
		static int longestPalSubstr(String str) { 
			int n = str.length(); // get length of input string 

			// table[i][j] will be false if substring str[i..j] 
			// is not palindrome. 
			// Else table[i][j] will be true 
			boolean table[][] = new boolean[n][n]; 

			// All substrings of length 1 are palindromes 
			int maxLength = 1; 
			for (int i = 0; i < n; ++i) 
				table[i][i] = true; 

			// check for sub-string of length 2. 
			int start = 0; 
			for (int i = 0; i < n - 1; ++i) { 
				if (str.charAt(i) == str.charAt(i + 1)) { 
					table[i][i + 1] = true; 
					start = i; 
					maxLength = 2; 
				}
			}
			
			// Check for lengths greater than 2. k is length 
			// of substring 
			for (int k = 3; k <= n; ++k) { 
				
					// Fix the starting index 
				for (int i = 0; i < n - k + 1; ++i) 
				{ 
					// Get the ending index of substring from 
					// starting index i and length k 
					int j = i + k - 1; 

					// checking for sub-string from ith index to 
					// jth index iff str.charAt(i+1) to 
					// str.charAt(j-1) is a palindrome 
					if (table[i + 1][j - 1] && str.charAt(i) == 
											str.charAt(j)) { 
						table[i][j] = true; 

						if (k > maxLength) { 
							start = i; 
							maxLength = k; 
						} 
					} 
				} 
			} 
			System.out.print("Longest palindrome substring is; "); 
			printSubStr(str, start, start + maxLength - 1); 
			
			return maxLength; // return length of LPS 
		} 

		// Driver program to test above functions 
		public static void main(String[] args) { 

//			String str = "forgeeksskeegfor"; 
//			System.out.println("Length is: " + longestPalSubstr(str));
			
			longestCommonPrefix(new String[] {"flower", "flow", "flight"});
			
			
		}
		
		// 8. String to Integer (atoi)
//	    public int myAtoi(String str) {
//	        int len = str.length();
//	        for (int i=0;i<len;i++) {
//	        	if (str.charAt(i)==' ');
//	        }
//	    }		
		
//		14. Longest Common Prefix
	    public static String longestCommonPrefix(String[] strs) {
	    	String result = "";
	    	for (int col=0; col<strs[0].length();col++) {
	    		for (int row =1;row<strs.length;row++) {
	    			if (strs[row].charAt(col) != strs[0].charAt(col) || col >= strs[row].length()) {
	    				return result;
	    			}
	    		}
	    		result = result + strs[0].charAt(col);
	    	}
	    	return result;
	        
	    }
	    
	    public String longestCommonPrefix2(String[] strs) {
	        String prefix = strs[0];
	        for (int row=1; row< strs.length; row++) {
	        	while (strs[row].indexOf(prefix) !=0) {
	        		prefix = prefix.substring(0, prefix.length()-1);
	        		if (prefix.isEmpty())
	        			return "";
	        	}
	        }
	        return prefix;
	    }
		
	} 
