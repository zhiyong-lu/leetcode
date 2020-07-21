import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//242. Valid Anagram
public class ValidAnagram242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "car", t = "rat";
		boolean res = isAnagram2(s, t);
		System.out.print(res);
	}
	
    public static boolean isAnagram1(String s, String t) {
    	if (s == null || t == null || s.length() != t.length()) return false;
    	
        char[] scharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();
        
        Arrays.sort(scharArray);
        Arrays.sort(tcharArray);
        
        String sStr = new String(scharArray);
        String tStr = new String(tcharArray);
        
        return sStr.equals(tStr)?true:false; 
    }
    
    public static boolean isAnagram2(String s, String t) {
    	if (s == null || t == null || s.length() != t.length()) return false;
    	
    	Map<Character, Integer> mapS = new HashMap<>();
    	Map<Character, Integer> mapT = new HashMap<>();
    	
    	for (int i = 0; i < s.length(); ++i) {
    		counter(mapS, s.charAt(i));
    		counter(mapT, t.charAt(i));
    	}
    	
//    	if (mapS.equals(mapT)) 
//    		return true;
//    	else
//    		return false;
    	return mapS.entrySet().stream().allMatch(e->e.getValue().equals(mapT.get(e.getKey())));
    	
    }

	private static void counter(Map<Character, Integer> map, char c) {
		int count = map.containsKey(c)?map.get(c):0;
		map.put(c, count+1);
	}
}
