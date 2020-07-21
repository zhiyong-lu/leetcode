
public class AddBinary67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addBinary("1", "111");
	}

	public static String addBinary(String a, String b) {
		if (a == null || b == null) return "";
		
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int aIdx = a.length() - 1, bIdx = b.length() - 1;
		
		while (aIdx >= 0 && bIdx >= 0) {
			int aValue = a.charAt(aIdx) - '0';
			int bValue = b.charAt(bIdx) - '0';
			
			int temp = aValue + bValue + carry;
			sb.append(temp % 2);
			carry = temp / 2;
			aIdx--;
			bIdx--;
		}
		
		while (aIdx >= 0) {
			int aValue = a.charAt(aIdx) - '0';
			sb.append((aValue + carry) % 2);
			carry = (aValue + carry) / 2;
			aIdx--;
		}
		
		while (bIdx >= 0) {
			int bValue = b.charAt(bIdx) - '0';
			sb.append((bValue + carry) % 2);
			carry = (bValue + carry) / 2;
			bIdx--;
		}
		
		return (carry == 1) ? sb.append("1").reverse().toString() : sb.reverse().toString();
		
	}
}
