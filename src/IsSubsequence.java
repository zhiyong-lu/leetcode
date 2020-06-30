import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//392. Is Subsequence
public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsSubsequence isSubsequence = new IsSubsequence();
		
		boolean b = isSubsequence.isSubsequenceBest("abc", "hakbagdc");
		b = isSubsequence.isSubsequenceMe("axc", "ahbgdc");
	}
	
	public boolean isSubsequenceMe(String s, String t) {
		int i = 0;
		
		for (int j=0; j<t.length() && i <s.length();j++) {
			if (s.charAt(i) == t.charAt(j))
				i++;
		}
		
		return i==s.length()?true:false;
    }
	
	public static boolean isSubsequence(String s, String t) {
//		Map<Character, List<Integer>> numCount = 
//			    IntStream.range(0, t.length())
//			             .filter(i -> str.charAt(i) != ' ')
//			             .boxed()
//			             .collect(Collectors.groupingBy(
//			                 i -> t.charAt(i),
//			                 Collectors.mapping(v -> v - 1, Collectors.toList());
//			             ));
		IntStream intStream = IntStream.range(0, t.length());
		Stream<Integer> stream = IntStream.range(0, t.length()).boxed();
//		System.out.println(stream.collect(Collectors.mapping(i->t.charAt(i), Collectors.toList())));
		Map<Character, List<Integer>> numCountMap = stream.collect(Collectors.groupingBy(i -> t.charAt(i), Collectors.mapping(Function.identity(), Collectors.toList())));
//		Map<Character, List<Integer>> numCountMap = stream.collect(Collectors.groupingBy(i -> t.charAt(i)));
//		List<Integer> result = stream.collect(Collectors.toList());
		
		for (int i=0; i<s.length(); i++) {
			List<Integer> currIndices = numCountMap.get(s.charAt(i));
			
		}
		return true;
	}
	
//	https://zhuhan0.blogspot.com/2017/07/leetcode-392-is-subsequence.html
	public boolean isSubsequenceBest(String s, String t) {
        List<Integer>[] positions = new ArrayList[26];
        
        int insertion1 = Collections.binarySearch(new ArrayList<>(Arrays.asList(2,5,6,7)), 5);
        int insertion2 = Collections.binarySearch(new ArrayList<>(Arrays.asList(2,5,6,7)), 0);
        int insertion3 = Collections.binarySearch(new ArrayList<>(Arrays.asList(2,5,6,7)), 8);
        int insertion4 = Collections.binarySearch(new ArrayList<>(Arrays.asList(2,5,6,7)), 9);
//        Collections.binarySearch(positions[index], last);
//        Collections.binarySearch(positions[index], last);
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (positions[index] == null) {
                positions[index] = new ArrayList<>();
            }
            positions[index].add(i);
        }
        
        int last = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (positions[index] == null) {
                return false;
            }
            int insertion = Collections.binarySearch(positions[index], last);
            if (insertion < 0) {
                insertion = - (insertion + 1);
            }
            if (insertion == positions[index].size()) {
                return false;
            }
            last = positions[index].get(insertion) + 1;
        }
        
        return true;
    }
}
