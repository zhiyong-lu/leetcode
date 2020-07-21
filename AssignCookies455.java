import java.util.Arrays;

public class AssignCookies455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findContentChildren(new int[] {10, 9, 8, 7}, new int[] {5, 6, 7, 8});
	}
	
//	https://www.cnblogs.com/grandyang/p/6077344.html
//    public static int findContentChildren(int[] g, int[] s) {
//        Arrays.sort(g);
//        Arrays.sort(s);
//        int k = 0;
//        int count = 0;
//        for (int i = 0; i < s.length; i++) {
//        	if (g[k] <= s[i]) {
//        		count++;
//        		k++;
//        		if (k>g.length - 1) break;
//        	}
//        }
//        return count;
//    }

	
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
    	int gIndex = 0, sIndex = 0, happy = 0;
    	while (sIndex < s.length) {
        	if ((gIndex < g.length) && g[gIndex] <= s[sIndex]) {
        		gIndex++;
        		happy++;
        		sIndex++;
        	} else {
        		sIndex++;
        	}
        }
    	return happy;
    }
}
