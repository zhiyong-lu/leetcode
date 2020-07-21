
public class Searcha2DMatrix74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) return false;
    	
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int n =  matrix[0].length;
        
        while (left <= right) {
        	int mid = left + (right - left) /2;
        	
        	if (matrix[mid/n][mid%n] == target) {
        		return true;
        	}
        	else if (matrix[mid/n][mid%n] < target) {
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        
        return false;
    }
	
	
}
