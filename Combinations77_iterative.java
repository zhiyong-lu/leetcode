import java.util.ArrayList;
import java.util.List;

public class Combinations77_iterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combineIterative(4, 2);
	}
	
	public static List<List<Integer>> combineIterative(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		int[] combination = new int[k];
		for (int i = 0; i < k; i++) {
			combination[i] = i;
		}

		while (combination[k - 1] < n) {
			List<Integer> comblist = new ArrayList<Integer>();
			for(int i=0; i<combination.length; i++) {
				comblist.add(combination[i]+1);
			}
			combinations.add(comblist);
			int t = k - 1;
			while (t != 0 && combination[t] == n - k + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < k; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return combinations;        
    }

}
