import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
//https://www.youtube.com/watch?v=PCb1Ca_j6OU
public class GenerateParentheses22 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		generateParenthesis(3);
	}
	
    public static List<String> generateParenthesis(int n) {
		List<String> resList = new ArrayList<>();
		String curr = "";
		
		helper(resList, curr, n, 0, 0);
		
		return resList;
    }

	private static void helper(List<String> resList, String curr, int n, int left, int right) {
		if (right == n) {
			resList.add(curr);
			return;
		}
		
		if (left < n) helper(resList, curr + "(", n, left+1, right);
		if (right < left) helper(resList, curr + ")", n, left, right + 1);
	}
}
