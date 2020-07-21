//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII59 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	https://www.youtube.com/watch?v=dfGhf-Ko0L4
    public static int[][] generateMatrix(int n) {
    	if (n == 0) return new int[0][0];
    	int[][] matrix = new int[n][n];
    	int top = 0, bottom = n - 1, left = 0, right = n - 1;
    	int k = 1;
    	
    	while (top < bottom && left < right) {
    		for (int j = left; j < right; j++) {
    			matrix[top][j] = k++;
    		}
    		for (int i = top; i < bottom; i++) {
    			matrix[i][right] = k++;
    		}
    		for (int j = right; j > left; j--) {
    			matrix[bottom][j] = k++;
    		}
    		for (int i = bottom; i > top; i--) {
    			matrix[i][left] = k++;
    		}
    		top++;
    		bottom--;
    		left++;
    		right--;
    	}
    	
    	if (n % 2 == 1) {
    		matrix[n/2][n/2] = k;
    	}
        return matrix;
    }

}
