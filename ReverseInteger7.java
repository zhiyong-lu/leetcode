
public class ReverseInteger7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = reverse(-123);
	}
    
	public static int reverse(int x) {
		if (x==0) return 0;
		
    	int res = 0;
		while (x!=0) {
        	res = res*10 + x%10;
        	x = x/10;
        }
		
		return res>=Integer.MAX_VALUE? 0 : (int)res;
    }
}
