import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//49. Group Anagrams 
public class GroupAnagrams49 {

	public static void main(String[] args) {
//		groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		groupAnagrams(new String[]{});
	}
	
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) 
        	return Collections.EMPTY_LIST;
        
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        
        for (String str : strs) {
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String sorted = new String(chars);
        	if (!map.containsKey(sorted)) {
        		map.put(sorted, count);
        		List<String> list = new ArrayList<>();
        		list.add(str);
        		result.add(list);
        		count++;
        	} else {
        		int index = map.get(sorted);
        		result.get(index).add(str);
        	}
        }
    	return result;
    }

}
