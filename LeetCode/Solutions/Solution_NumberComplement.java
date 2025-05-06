public class Solution_NumberComplement {
	public static int findComplement(int num) {
		String binaryString = Integer.toBinaryString(num);
		int result = 0;

		for (int i = binaryString.length() - 1, multi = 1; i >= 0; --i, multi *= 2) {
			int n = (binaryString.charAt(i) - '0') ^ 1;

			result += n * multi;
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(findComplement(5)); // 2
		System.out.println(findComplement(1)); // 0
	}
}
