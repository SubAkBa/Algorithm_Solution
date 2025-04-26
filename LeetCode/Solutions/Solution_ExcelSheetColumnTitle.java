import java.util.HashMap;
import java.util.Map;

public class Solution_ExcelSheetColumnTitle {
	public static String convertToTitle(int columnNumber) {
		Map<Integer, Character> numToAlphaMap = new HashMap<>();

		for (int i = 0; i < 26; ++i) {
			numToAlphaMap.put(i, (char)((int)'A' + i));
		}

		StringBuilder sb = new StringBuilder();
		int value = columnNumber;

		while (value > 0) {
			--value;
			int remainder = value % 26;

			sb.append(numToAlphaMap.get(remainder));

			value /= 26;
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(1)); // "A"
		System.out.println(convertToTitle(28)); // "AB"
		System.out.println(convertToTitle(701)); // "ZY"
	}
}
