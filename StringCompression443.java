
public class StringCompression443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = new char[] {'a','a','b','b','c','c','c'};
		
		compress(chars);
	}
	
    public static int compress(char[] chars) {
//        if (chars == null) return -1;
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;  
    }

}
