import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	https://www.cnblogs.com/grandyang/p/6077344.html
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int k = 0;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
        	if (g[k] <= s[i]) {
        		count++;
        		k++;
        		if (k>g.length - 1) break;
        	}
        }
        return count;
    }

}
