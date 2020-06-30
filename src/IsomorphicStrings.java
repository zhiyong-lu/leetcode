import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isIsomorphic("paper", "title");
	}
	
	public static boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		
		for (int i=0; i<s.length();i++) {
			if (m1[s.charAt(i)] != m1[t.charAt(i)]) 
				return false;
			m1[s.charAt(i)]++;
			m2[t.charAt(i)]++;
		}
		return true;
	}
	
	public static boolean isIsomorphic2(String s, String t) {
		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();
		
		for (int i=0; i<s.length();i++) {
			Character ccc = new Character((char) 0);
			
			int count1 = m1.containsKey(s.charAt(i))? m1.get(s.charAt(i)):0;
			m1.put(s.charAt(i), count1+1);
			
			int count2 = m2.containsKey(t.charAt(i))? m2.get(t.charAt(i)):0;
			m2.put(t.charAt(i), count2+1);
		}
		return true;
	}
}
	
