
public class RepeatedSubstringPattern459 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        
        for (int i = len / 2; i > 0; i--) {
        	if (s.length() % i == 0) {
        		String str = s.substring(0, i);
        		int repeat = s.length() / i;
        		StringBuilder sb = new StringBuilder();        		
        		for (int j = 0; j < repeat; j++) {
        			sb.append(str);
        		}
        		if (sb.toString().equalsIgnoreCase(s)) return true;
        	}
        }
        return false;
    }
}
