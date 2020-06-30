import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid("(((((((()");
	}
	
//    public static boolean isValid(String str) {
//    	
//    	int i=0, j=str.length();
//    	
//    	while (i<j) {
//    		if (str.charAt(i) == '{' && str.charAt(j) == '}'
//    			|| str.charAt(i) == '(' && str.charAt(j) == ')'
//    			|| str.charAt(i) == '[' && str.charAt(j) == ']') {
//    			i++;
//    			j--;
//    		} else {
//    			return false;
//    		}
//    	}
//    	return true;
//    }
    
	public static boolean isValid(String str) {	
    	Stack<Character> stack = new Stack<>();
    	
    	for (int i=0; i<str.length(); i++) {
    		if (str.charAt(i) == '{' 
    			||str.charAt(i) == '['
    			||str.charAt(i) == '(') {
    			stack.push(str.charAt(i));
    		} else {
    			Character c = stack.pop();
    			if (c.equals(Character.valueOf('{')) && str.charAt(i) != '}'
    				|| c.equals(Character.valueOf('[')) && str.charAt(i) != ']'
    				|| c.equals(Character.valueOf('(')) && str.charAt(i) != ')') {
    				return false;
    			}
    		}
    	}
    	if (!stack.isEmpty()) 
    		return false;
    	
    	return true;
    }

}
