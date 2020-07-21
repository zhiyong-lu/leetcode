//https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
//https://www.geeksforgeeks.org/find-the-number-of-islands-set-2-using-disjoint-set/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class NumberofIslands_DisjointSet {

	public static void main(String[] args) {
		
		int[][] a = new int[][] {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 1, 0, 0}, 
            {1, 0, 0, 0, 1} 
           };
           System.out.println("Number of Islands is: " + 
        		   numIslandsDisjointSet(a)); 
	}
	
	 public static int numIslandsDisjointSet(int[][] grid) {
		 int m = grid.length, n = grid[0].length;
		 
		 DisjointSet ds = new DisjointSet(m*n);
		 
//		 The following loop checks for its neighbours 
//       and unites the indexes if both are 1. 
		 for (int i = 0; i < m; i++) {
			 for (int j = 0; j < n; j++){
				// If cell is 0, nothing to do 
				 if (grid[i][j] == 0)
					 continue;
				 
				// Check all 4 neighbours and do an union 
	            // with neighbor's set if neighbor is also 1
				 if (i+1 < m && grid[i+1][j] == 1) {
					 ds.union(i*m+j, (i+1)*m+j);
				 }
				 if (i-1>=0 && grid[i-1][j] == 1) {
					 ds.union(i*m+j, (i-1)*m+j);
				 }
				 if (j+1<n && grid[i][j+1] == 1) {
					 ds.union(i*m+j, i*m+(j+1));
				 }
				 if (j-1>=0 && grid[i][j-1] == 1) {
					 ds.union(i*m+j, i*m+j-1);
				 }
			 }
		 }
		 
		 Set<Integer> set = new HashSet<>();
		 for (int i = 0; i < m; i++) {
			 for (int j = 0; j < n; j++){
				 if (grid[i][j] == 1) {
					 int x = ds.find(i*m + j);
					 set.add(x);
				 }
			 }
		 }
		 
		 return set.size();
	 }
	 
	 //***************
     static int countIslands(int a[][]) 
     { 
        int n = a.length; 
        int m = a[0].length; 
  
        DisjointSet dus = new DisjointSet(n*m); 
  
        /* The following loop checks for its neighbours 
           and unites the indexes  if both are 1. */
        for (int j=0; j<n; j++) 
        { 
            for (int k=0; k<m; k++) 
            { 
                // If cell is 0, nothing to do 
                if (a[j][k] == 0) 
                    continue; 
  
                // Check all 8 neighbours and do a union 
                // with neighbour's set if neighbour is  
                // also 1 
                if (j+1 < n && a[j+1][k]==1) 
                    dus.union(j*(m)+k, (j+1)*(m)+k); 
                if (j-1 >= 0 && a[j-1][k]==1) 
                    dus.union(j*(m)+k, (j-1)*(m)+k); 
                if (k+1 < m && a[j][k+1]==1) 
                    dus.union(j*(m)+k, (j)*(m)+k+1); 
                if (k-1 >= 0 && a[j][k-1]==1) 
                    dus.union(j*(m)+k, (j)*(m)+k-1); 
                if (j+1<n && k+1<m && a[j+1][k+1]==1) 
                    dus.union(j*(m)+k, (j+1)*(m)+k+1); 
                if (j+1<n && k-1>=0 && a[j+1][k-1]==1) 
                    dus.union(j*m+k, (j+1)*(m)+k-1); 
                if (j-1>=0 && k+1<m && a[j-1][k+1]==1) 
                    dus.union(j*m+k, (j-1)*m+k+1); 
                if (j-1>=0 && k-1>=0 && a[j-1][k-1]==1) 
                    dus.union(j*m+k, (j-1)*m+k-1); 
            } 
        } 
  
        // Array to note down frequency of each set 
        int[] c = new int[n*m]; 
        int numberOfIslands = 0; 
        for (int j=0; j<n; j++) 
        { 
            for (int k=0; k<m; k++) 
            { 
                if (a[j][k]==1) 
                { 
  
                    int x = dus.find(j*m+k); 
  
                    // If frequency of set is 0,  
                    // increment numberOfIslands 
                    if (c[x]==0) 
                    { 
                        numberOfIslands++; 
                        c[x]++; 
                    } 
  
                    else
                        c[x]++; 
                } 
            } 
        } 
        return numberOfIslands; 
    }
	
}
