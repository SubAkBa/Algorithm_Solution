/*
@lc.idx: 67
@lc.slug: add-binary
@lc.title: add binary
@lc.level: Easy
@lc.tags: Math, String, Bit Manipulation, Simulation
@lc.complexity: O(N)/O(1)
@lc.note:
*/

public class Solution_AddBinary {
	public static String addBinary(String a, String b) {
		int aIdx = a.length() - 1;
		int bIdx = b.length() - 1;
		int plus = 0;
		StringBuilder sb = new StringBuilder();

		while (aIdx >= 0 || bIdx >= 0 || plus > 0) {
			int aNum = aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
			int bNum = bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;
			int sum = aNum + bNum + plus;

			plus = sum / 2;
			int remainder = sum % 2;

			sb.append(remainder);

			--aIdx;
			--bIdx;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("11", "1")); // "100"
		System.out.println(addBinary("1010", "1011")); // "10101"
		System.out.println(addBinary("10000", "100")); // "10100"
		System.out.println(addBinary("10000", "0")); // "10000"
		System.out.println(addBinary("0", "0")); // "0"
		System.out.println(addBinary("1111", "1111")); // "11110"
		System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011")); // "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
	}
}
