import java.util.HashSet;
import java.util.Set;

//67. Add Binary
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AddBinary addBinary = new AddBinary();
//		addBinary.addBinary("1010", "1011");
		
//		isPalindrome("race a car");
//		reverseString(new char[]{'h','e','l','l','o'});
		
//		reverseVowels("leetcode");
		
//		firstUniqChar("loveleetcode");
		
//		addStrings("929","496");
		
//		countSegments("     Hello, my      name is John ");
		
//		compressInPlace(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
		
//		repeatedSubstringPattern("abcabcabcabc");
		
//		detectCapitalUse("FlaG");
		
		reverseStr("abcdefg", 2);
		
	}
	
//	67. Add Binary
    public String addBinary(String a, String b) {
        int total1 = 0;
        int total2 = 0;
        
        for (char c: a.toCharArray()) {
        	total1 = total1*2 + (c-'0');
        }
        
        for (char c: b.toCharArray()) {
        	total2 = total2*2 + (c-'0');
        }
        
        int total = total1 + total2;
        String result = "";
        while (total > 0) {
        	result = total % 2 + result;
        	total = total / 2;
        }
        return result; 
    }
    
//    https://www.cnblogs.com/grandyang/p/4084971.html
    public String addBinary2(String a, String b) {
    	String result = "";
    	int aIndex = a.length()-1;
    	int bIndex = b.length()-1;
    	int carry = 0;
    	
    	while (aIndex >=0 || bIndex>=0) {
    		int aCurrValue = aIndex>=0? a.charAt(aIndex--) - '0':0;
    		int bCurrValue = bIndex>=0? b.charAt(bIndex--) - '0':0;
    		int currTotal = aCurrValue + bCurrValue + carry;
    		result = currTotal%2 + result;
    		carry = currTotal / 2;
    	}
    	
    	return carry==1? "1"+result:result;
    }
    
//    125. Valid Palindrome
    public static boolean isPalindrome(String s) {
    	Set<Character> set = new HashSet<>();
    	
    	for (int i=0; i<26; i++) {
    		set.add((char) (i+'a'));
    		set.add((char) (i+'A'));
    	}
    	
    	int left = 0;
    	int right = s.length()-1;
    	
    	while (left < right) {
    		if (!set.contains(s.charAt(left))) {
    			left++;
    			continue;
    		} else if (!set.contains(s.charAt(right))) {
    			right--;
    			continue;
    		}
    		
    		if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	
    	return true;
        
    }
    
//    344. Reverse String
    public static void reverseString(char[] s) {
    	
    	for (int left=0, right=s.length-1; left < right; left++, right--) {
    		char temp = s[right];
    		s[right] = s[left];
    		s[left] = temp;
    	}
    
     System.out.print(s);
    }
    
//    345. Reverse Vowels of a String
    public static String reverseVowels(String s) {
    	int left = 0;
    	int right = s.length()-1;
    	StringBuilder sb = new StringBuilder(s);
    	
    	while (left < right) {
    		if (!isVowel(s.charAt(left))) {
    			left++;
    			continue;
    		} else if (!isVowel(s.charAt(right))) {
    			right--;
    			continue;
    		}
    		
    		char temp = s.charAt(right);
    		sb.setCharAt(right--, s.charAt(left));
    		sb.setCharAt(left++, temp);
    	}
    	
    	return sb.toString();
    }
    
    private static boolean isVowel(char c) {
    	c = Character.toLowerCase(c);
    	return c=='a' || c=='e' || c=='u' ||c=='e' || c=='o';
    }
    
//  387 First Unique Character in a String
    public static int firstUniqChar(String s) {
    	int indices[] = new int[26];
    	
    	for (int i=0; i<s.length(); i++) {
    		if (indices[s.charAt(i)-'a'] ==0) {
    			indices[s.charAt(i)-'a'] = i+1;
    		} else {
    			indices[s.charAt(i)-'a'] = s.length()+1;
    		}
    	}
    	
    	int min = s.length()+1;
    	for (int idx:indices) {
    		if (idx != s.length()+1 && idx != 0) {
    			min = Math.min(idx, min);
    		}
    	}
        return min - 1;
    }
    
//    415. Add Strings
    public static String addStrings(String num1, String num2) {
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int carry = 0;
        int indexNum1 = num1.length()-1;
        int indexNum2 = num2.length()-1;
        String total = "";
        while (indexNum1 >= 0 || indexNum2 >= 0) {
        	int currNum1 = indexNum1 >= 0? num1Chars[indexNum1--] - '0':0;
        	int currNum2 = indexNum2 >= 0? num2Chars[indexNum2--] - '0':0;
        	int currTotal = currNum1 + currNum2 + carry;
        	carry = currTotal / 10;
        	total = currTotal % 10 + total;
        }
        
        return carry == 1? "1"+total:total;
        
    }
    
//    434. Number of Segments in a String
    public static int countSegments(String s) {
    	int index = 0;
    	while (s.charAt(index) == ' ') {
    		index++;
    	}

    	char previousChar = s.charAt(index);
    	int count=0;
        for (int i=index; i<s.length();i++) {
        	if (s.charAt(i)==' ') {
        		if (previousChar == ' ') {
        			continue;
        		} 
        		count++;
        	}
        	previousChar = s.charAt(i);
        }

        return s.charAt(s.length()-1) != ' '?1+count:count;
    }
    
//    443. String Compression
    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        
    	char preChar = chars[0];
    	int count=1;
    	StringBuilder sb = new StringBuilder();
    	for (int i=1; i<chars.length; i++) {
    		if (chars[i] == preChar) {
    			count++;
    		} else {
    			sb = count>1?sb.append(preChar).append(count):sb.append(preChar);
    			preChar = chars[i];
    			count = 1;
    		}
    	}
    	sb = count>1?sb.append(preChar).append(count):sb.append(preChar);
    	return sb.toString().toCharArray().length;
    }
    
//  443. String Compression
    public static int compressInPlace(char[] chars) {
        if (chars.length == 1) return 1;
    	char preChar = chars[0];
    	int count=1;
    	int readIndex = 1;
    	int writeIndex = 0;
    	while (readIndex < chars.length) {
    		if (preChar == chars[readIndex]) {
    			count++;
    		} else {
    			if (count>1) {
    				chars[writeIndex] = preChar;
    				chars[writeIndex+1] = (char) ('0' + count);
    				writeIndex=writeIndex+2;
    			} else {
    				chars[writeIndex++] = preChar;
    			}
    			preChar = chars[readIndex];
    			count = 1;
    		}
    		readIndex++;
    	}
    	
    	if (count>1) {
			chars[writeIndex] = preChar;
			chars[writeIndex+1] = (char) ('0' + count);
		} else {
			chars[writeIndex] = preChar;
		}
    	
    	return writeIndex++;
    }
    
//    459. Repeated Substring Pattern
    static boolean repeatedSubstringPattern(String str) {
        int n = str.length();
        for (int i = n / 2; i >= 1; --i) {
            if (n % i == 0) {
                int c = n / i;
                String t = "";
                for (int j = 0; j < c; ++j) {
                    t += str.substring(0, i);
                }
                if (t == str) return true;
            }
        }
        return false;
    }
    
    
//    520. Detect Capital
//    https://www.cnblogs.com/grandyang/p/6512921.html
    public static boolean detectCapitalUse(String word) {
        boolean allLow = false;
        boolean allUpper = false;
        boolean allFirstUpperAllLow = false;
        
        char firstChar = word.charAt(0);
        char secondChar = word.charAt(1);
        if (firstChar > 'A' && firstChar < 'Z') {
        	if (secondChar > 'A' && secondChar < 'Z') {
        		allUpper = true;	
        	} else {
        		allFirstUpperAllLow = true;
        	}
        } else if (firstChar > 'a' && firstChar < 'z') {
        	allLow = true;
        }
        
        for (int i=1; i<word.length(); i++) {
        	if (allUpper) {
        		if (word.charAt(i) > 'a' && word.charAt(i) < 'z') {
        			return false;
        		}
        	} else if (allFirstUpperAllLow || allLow) {
        		if (word.charAt(i) > 'A' && word.charAt(i) < 'Z') {
        			return false;
        		}
        	}
        }
        
        return true;
    }
    
//    541. Reverse String II
    public static String reverseStr(String s, int k) {
    	StringBuilder sb = new StringBuilder(s);
    	for (int i=0; i<s.length()-1; i=i+2*k) {
    		char temp = s.charAt(i);
    		sb.setCharAt(i, s.charAt(i+1));
    		sb.setCharAt(i+1, temp);
    	}
    	return sb.toString();
    }
}
