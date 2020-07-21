// 367. Valid Perfect Square
public class ValidPerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isPerfectSquare(int num) {
		int left = 0;
		int right = num;
		
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (mid*mid == num) 
				return true;
			if (mid*mid < num) 
				left = mid + 1;
			else 
				right = mid - 1;
		}
		return false;
    }

}
