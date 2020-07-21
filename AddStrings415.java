
public class AddStrings415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static String addStrings(String num1, String num2) {
       if (num1 == null && num2 == null) return null;
       if (num1 == null) return num2;
       if (num2 == null) return num1;
       
       int num1Len = num1.length() - 1, num2Len = num2.length() - 1;
       int carry = 0;
       StringBuilder sb = new StringBuilder();
       
       while (num1Len >= 0 || num2Len >= 0) {
    	   int v1 = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
    	   int v2 = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
    	   int temp = v1 + v2 + carry;
    	   sb.append(temp % 10);
    	   carry = temp / 10;
    	   num1Len--;
    	   num2Len--;
       }
       
       if (carry > 0) 
    	 sb.append(carry);
       
       return sb.reverse().toString();
       
    }
	
}
