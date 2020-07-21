
public class PlusOne66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) return new int[0];
    	
        int len = digits.length;
        int carry = 1;
        
        for (int i = len - 1; i >= 0; i--) {
        	int currValue = digits[i] + carry;
        	if (currValue >= 10) {
        		carry = 1;
        	} else {
        		carry = 0;
        	}
        	digits[i] = currValue % 10;
        }
        
        if (carry == 1) {
        	int[] newDigits = new int[len+1];
        	System.arraycopy(digits, 0, newDigits, 1, len);
        	newDigits[0] = 1;
        	return newDigits;
        } else {
        	return digits;
        }
    }

}
