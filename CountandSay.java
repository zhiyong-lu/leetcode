
public class CountandSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = countAndSayMe(111221);
		System.out.print(str);
	}
	
    public static String countAndSayMe(int num) {
    	String strNum = String.valueOf(num);
    	char preChar = strNum.charAt(0);
    	int count = 1;
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=1; i<strNum.length();i++) {
    		if (preChar == strNum.charAt(i)) {
    			count++;
    		} else {
    			sb.append(count).append(preChar-'0');
    			count=1;
    			preChar = strNum.charAt(i);
    		}
    	}
    	
    	sb.append(count).append(preChar - '0');
    	
    	return sb.toString();
    }

}
