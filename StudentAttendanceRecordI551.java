import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentAttendanceRecordI551 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = checkRecord3("PPALLP");
	}

	public static boolean checkRecord1(String s) {
        if (s == null) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == 'A') {
        		 if (map.containsKey('A')) return false;
        		 else map.put('A', 1);
        		 map.remove('L');
        	} else if (s.charAt(i) == 'L') {
        		int count = map.containsKey('L')?map.get('L'):0;
        		count += 1;
        		if (count > 2) return false;
        		map.put('L', count);
        	} else {
        		map.remove('L');
        	}
        }
        return true;
    }
	
	public static boolean checkRecord2(String s) {
		int aCount = 0, lCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				aCount++;
				if (aCount > 1) return false;
				lCount = 0;
			} else if (s.charAt(i) == 'L') {
				lCount++;
				if (lCount > 2) return false;
			} else {
				lCount = 0;
			}
		}
		return true;
	}
	
	public static boolean checkRecord3(String s) {
		Pattern pattern = Pattern.compile("A.*A|LLL");
		Matcher matcher = pattern.matcher(s);
		return matcher.find()? false:true;
	}
}
