//130. Surrounded Regions
public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static void solve(char[][] board) {
    	
    	int rowLen = board.length;
    	int colLen = board[0].length;
    	
    	for (int j = 0; j < colLen-1; j++) {
    		if (board[0][j] == 'O') boardDFS(board, 0, j);
    		if (board[rowLen-1][j] == 'O') boardDFS(board, rowLen-1, j);
    	}
    	
    	for (int i = 0; i < rowLen-1; i++) {
    		if (board[i][0] == 'O') boardDFS(board, i, 0);
    		if (board[i][colLen-1] == 'O') boardDFS(board, i, colLen-1);
    	}
    	
    	for (int i=0; i<rowLen;i++) {
    		for (int j=0; j<colLen;j++) {
    			if (board[i][j]=='O') board[i][j]='X';    			
    		}
    	}
    	
    	for (int i=0; i<rowLen;i++) {
    		for (int j=0; j<colLen;j++) {
    			if (board[i][j]=='$') board[i][j]='O';    			
    		}
    	} 
    }

	private static void boardDFS(char[][] board, int i, int j) {
		if (i<0 || j<0 || i > board.length-1 || j >board[0].length-1) return;
		
		if (board[i][j] == 'O') board[i][j] = '$';
		
		if (i >0 && board[i-1][j] == 'O') boardDFS(board, i-1,j);
		if (i < board.length && board[i+1][j] == 'O') boardDFS(board, i+1,j);
		if (j >0 && board[i][j-1] == 'O') boardDFS(board, i,j-1);
		if (j <board[0].length && board[i][j+1] == 'O') boardDFS(board, i,j+1);
	}

}
