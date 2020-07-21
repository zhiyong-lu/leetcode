import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("abcdefgbkjl");
		
	}
	
    public static int lengthOfLongestSubstringMe(String s) {
    	int currCount = 0;
    	int max = Integer.MIN_VALUE;
    	Set<Character> set = new HashSet<>();
    	
    	for (int i=0; i<s.length();i++) {
    		Character c = s.charAt(i);
    		if (!set.contains(c)) {
    			set.add(c);
    			currCount++;
    		} else {
    			set.clear();
    			set.add(c);
    			max = Math.max(currCount, max);
    			currCount = 1;
    		}
    	}
    	return max;
    }
    
//    https://www.cnblogs.com/grandyang/p/4480780.html
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    public static int lengthOfLongestSubstringAgain(String s) {
    	 if (s == null || s.length() == 0) return 0;
         
         int left = 0, right = 0;
     	int max = Integer.MIN_VALUE;
     	boolean[] used = new boolean[128];
     	Arrays.fill(used, false);
     	
     	while (right < s.length()) {
     		if (used[s.charAt(right)] == false) {
     			used[s.charAt(right)] = true;
     			right++;
     		} else {
     			max = Math.max(max, right - left);
     			while (left < right && s.charAt(left) != s.charAt(right)) {
     				used[s.charAt(left)] = false;
     				left++;
     			}
     			left++;
     			right++;
     		}
     	}
         max = Math.max(max, right - left);
     	return max;
    }
}
