
public class LongestPalindrome {

//	public static void main(String[] args) {
//		
//
//	}
//	
//	public String longestPalindrome(String s) {
//		String longestPalindrome = "";
//		
//		
//		
//		return longestPalindrome;        
//    }
//	
//	public boolean isPalindrome
	
	 static int maxSubArraySum(int a[], int size) 
	 { 
		int startIndex = 0;
		int endIndex = 0;
	    int max_so_far = a[0]; 
	    int curr_max = a[0]; 
	  
	    for (int i = 1; i < size; i++) 
	    { 
	    	if (a[i] > curr_max + a[i]) {
	    		System.out.println("startIndex = "+ i);
	    	}
	        curr_max =	Math.max(a[i], curr_max + a[i]); 
	        max_so_far= Math.max(max_so_far, curr_max); 
	        if (max_so_far == curr_max)
	        {
	        	System.out.println("endIndex = "+ i);
	        }
	    } 
	    return max_so_far; 
	 } 
	  
	/* Driver program to test maxSubArraySum */
    public static void main(String[] args) 
    { 
//	    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
    	int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; 
	    int n = a.length;    
	    int max_sum = maxSubArraySum(a, n); 
	    System.out.println("Maximum contiguous sum is " 
	                       + max_sum); 
    }
    
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
      }

      public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
      }
    
}
