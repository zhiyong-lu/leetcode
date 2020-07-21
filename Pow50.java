//50. Pow(x, n)
public class Pow50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double result = myPow(2.00000, -2);
		System.out.print(result);
	}
	
	public static double myPow(double x, int n) {
		int m = (n>0) ? n:-n;
    	double result = myPowHelper(x, m);
    	
    	if (n > 0) 
    		return result;
    	else 
    		return 1/result;
    }

	
    public static double myPowHelper(double x, int n) {
        if (n == 0) return 1;
        
        double half = myPow(x, n/2);
    	double result = (n%2 == 0) ? half * half : half * half * x;
    	 
    	return result;
    	
    }

}
