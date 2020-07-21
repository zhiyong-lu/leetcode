import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//200. Number of Islands
public class NumberofIslands {

	public static void main(String[] args) {
		char[][] grid = new char[][] {
			{'1','1','0','0','0'},
			{'1','1','0','0','0'},
			{'0','0','1','0','0'},
			{'0','0','0','1','1'}
		};
		int count  = numIslandsBFS(grid);
	}
	
	 public static int numIslands(char[][] grid) {
		 int m = grid.length;
		 int n = grid[0].length;
		 boolean[][] visited = new boolean[grid.length][grid[0].length];
		 int count = 0;

		 for (int i = 0; i < m; ++i) {
			 for (int j = 0; j < n; ++j) {
				 if (grid[i][j] == '1' && visited[i][j] == false) {
					 dfs(grid, i, j, visited);
					 count++;
				 }
			 }
		 }
		 return count;
	 }

	private static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
		if (row > grid.length - 1 || col > grid[0].length - 1 || row < 0 || col < 0 || grid[row][col] != '1' || visited[row][col]) return;
		
		visited[row][col] = true;

		dfs(grid, row+1, col, visited);
		dfs(grid, row-1, col, visited);
		dfs(grid, row, col+1, visited);
		dfs(grid, row, col-1, visited);
	}
	
	
	
//    public static int numIslands(char[][] grid) {
//        
//    	int[] dx = new int[] {-1, 1, 0, 0};
//    	int[] dy = new int[] {0, 0, -1, 1};
//    	
//    	int row = grid.length - 1;
//    	int col = grid[0].length - 1;
//    	
//    	for (int i = 0; i < row; ++i) {
//    		if (grid[i][0] == 'O') floodfillDFS(grid, i, 0, dx, dy);
//    		if (grid[i][col] == 'O') floodfillDFS(grid, i, col, dx, dy);
//    	}
//    	
//    	for (int j = 0; j < col; ++j) {
//    		if (grid[0][j] == 'O') floodfillDFS(grid, 0, j, dx, dy);
//    		if (grid[row][j] == 'O') floodfillDFS(grid, row, j, dx, dy);
//    	}
//    	
//    	int count = 0;
//    	for (int i = 0; i < row; i++) {
//    		for (int j = 0; i < col; j++) {
//    			if (grid[i][j] != 'O') continue;
//    			
//    			floodfillDFS(grid, row, j, dx, dy);
//    			count++;
//    		}
//    	}
//    	return count;
//    }
//
//	private static void floodfillDFS(char[][] grid, int row, int col, int[] dx, int[] dy) {
//		if (row < 0 || col < 0 || row > grid.length - 1 || col > grid[0].length - 1 || grid[row][col] != 'O') return;
//		
//		if (grid[row][col] == 'O') {
//			grid[row][col] = '$';
//		}
//		
//		floodfillDFS(grid, row + 1, col, dx, dy);
//		floodfillDFS(grid, row - 1, col, dx, dy);
//		floodfillDFS(grid, row, col + 1, dx, dy);
//		floodfillDFS(grid, row, col - 1, dx, dy);
//	}
	
	 public static int numIslandsBFS(char[][] grid) {
		 int m = grid.length, n = grid[0].length;
		 boolean visited[][] = new boolean[m][n];
		 int count = 0;
		 
		 for (int i = 0; i <m; i++) {
			 Arrays.fill(visited[i],  false);
		 }
		 
		 for (int i = 0; i < m; i++) {
			 for (int j = 0; j < n; j++) {
				 if (grid[i][j] != '0' && visited[i][j] != true) {
					 BFS(grid, i, j, visited);
					 count++;
				 }
			 }
		 }
		 return count;		 
	 }

	private static void BFS(char[][] grid, int i, int j, boolean[][] visited) {
		if (i<0 || i>=grid.length || j <0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0') return;
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(i + "," + j);
//		visited[i][j] = true;
		while (!queue.isEmpty()) {
			String temp = queue.poll();
			String[] strs = temp.split(",");
			int row = Integer.valueOf(strs[0]);
			int col = Integer.valueOf(strs[1]);
			
			if (row < 0 || row >= grid.length || col < 0 || col >=  grid[0].length || visited[row][col] == true || grid[row][col] == '0') 
				continue;
			
			visited[row][col] = true;
			
			queue.offer((row + 1) + "," + col);
			queue.offer((row - 1) + "," + col);
			queue.offer(row + "," + (col + 1));
			queue.offer(row + "," + (col - 1));
		}
	}
}


// Disjoint set 


