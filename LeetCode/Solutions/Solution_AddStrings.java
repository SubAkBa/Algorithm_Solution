public class Solution_AddStrings {
	public static String addStrings(String num1, String num2) {
		int n1Idx = num1.length() - 1;
		int n2Idx = num2.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();

		while (n1Idx >= 0 || n2Idx >= 0 || carry > 0) {
			int n1 = n1Idx < 0 ? 0 : num1.charAt(n1Idx) - '0';
			int n2 = n2Idx < 0 ? 0 : num2.charAt(n2Idx) - '0';
			int calc = n1 + n2 + carry;
			carry = calc / 10;

			sb.append(calc % 10);

			if (n1Idx >= 0) {
				--n1Idx;
			}

			if (n2Idx >= 0) {
				--n2Idx;
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addStrings("11", "123")); // "134"
		System.out.println(addStrings("456", "77")); // "533"
		System.out.println(addStrings("0", "0")); // "0"
		System.out.println(addStrings("1", "9")); // "10"
		System.out.println(addStrings("1", "99")); // "100"
	}
}
